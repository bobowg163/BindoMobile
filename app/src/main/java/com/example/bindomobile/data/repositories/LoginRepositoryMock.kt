package com.example.bindomobile.data.repositories

import android.content.SharedPreferences
import android.util.Log
import com.cioccarellia.ksprefs.KsPrefs
import com.example.bindomobile.data.app.PrefKeys
import com.example.bindomobile.data.datasource.local.dao.AccountDao
import com.example.bindomobile.data.datasource.local.dao.AgencyDao
import com.example.bindomobile.data.datasource.local.dao.CountryDao
import com.example.bindomobile.data.datasource.local.dao.PersonInfoDao
import com.example.bindomobile.data.datasource.local.dao.SFDDao
import com.example.bindomobile.data.datasource.local.entities.AccountEntity
import com.example.bindomobile.data.datasource.local.entities.AgencyEntity
import com.example.bindomobile.data.datasource.local.entities.CountryEntity
import com.example.bindomobile.data.datasource.local.entities.PersonInfoEntity
import com.example.bindomobile.data.datasource.local.entities.SFDEntity
import com.example.bindomobile.data.datasource.remote.api.ClientApiService
import com.example.bindomobile.data.datasource.remote.dtos.Agence
import com.example.bindomobile.data.datasource.remote.dtos.Compte
import com.example.bindomobile.data.datasource.remote.dtos.Pays
import com.example.bindomobile.data.datasource.remote.dtos.PersonneInfo
import com.example.bindomobile.data.datasource.remote.dtos.Sfd
import com.example.bindomobile.domain.core.AppError
import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.repositories.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/16
 * @time 下午7:40
 * @month_full 十月
 * @day 16
 * @day_full 星期三
 * @minute 40
 */
class LoginRepositoryMock(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val prefs: KsPrefs,
    private val securedPrefs: SharedPreferences,
    private val accountDao: AccountDao,
    private val countryDao: CountryDao,
    private val sfdDao: SFDDao,
    private val agencyDao: AgencyDao,
    private val personInfoDao: PersonInfoDao,
    private val api: ClientApiService
) : LoginRepository {

    override suspend fun login(username: String, password: String) =
        withContext(coroutineDispatcher) {
            delay(MOCK_DELAY)

            // Call login API
            val loginResponse = api.login(username, password, 35300)

            val responseObject = loginResponse.body()

            if (loginResponse.isSuccessful && responseObject != null && responseObject.code == 0) {
                Log.i("LoginRepositoryMock", "Login successful ${responseObject.value}")
                // If login is successful, call grantee API
                val granteeResponse = api.grantee(responseObject.value)
                Log.i("LoginRepositoryMock", "Grantee API call")
                val personneInfo = granteeResponse.body()

                if (personneInfo != null) {
                    Log.i("LoginRepositoryMock", "Grantee API is not null")
                    //Add personneInfo to local database
                    addPersonneInfo(personneInfo)

                    // If grantee API is successful, call accounts API
                    val accountsResponse =
                        api.accounts(responseObject.value)
                    Log.i("LoginRepositoryMock", "Accounts API call")
                    val compteSFDs = accountsResponse.body()

                    if (compteSFDs != null) {
                        Log.i("LoginRepositoryMock", "Accounts API is not null")
                        //Adding user token to pref
                        prefs.push(PrefKeys.IS_LOGGED_IN.name, true)
                        prefs.push(PrefKeys.USER_TOKEN.name, responseObject.value)
                        prefs.push(PrefKeys.USERNAME.name, username)

                        // Add accounts to local database
                        treatAccounts(compteSFDs.compteSFDs)
                    } else {
                        throw AppError(ErrorType.DATA_FETCHING_ERROR)
                    }
                } else {
                    throw AppError(ErrorType.DATA_FETCHING_ERROR)
                }
            } else {
                Log.i("LoginRepositoryMock", "Login failed")
                throw AppError(ErrorType.USER_NOT_FOUND)
            }
        }


    override suspend fun checkIfLoggedIn(): Boolean {
        delay(MOCK_DELAY)
        return prefs.pull(PrefKeys.IS_LOGGED_IN.name, false)
    }

    override suspend fun logOut() = withContext(coroutineDispatcher) {
        delay(MOCK_DELAY)
        //Call Logout API

        // Clear app settings
        prefs.push(PrefKeys.IS_LOGGED_IN.name, false)

        // Clear encrypted storage
        securedPrefs.edit().clear().apply()
    }

    private suspend fun treatAccounts(remoteAccounts: List<Compte>) {
        if (remoteAccounts.isEmpty()) return
        val localAccounts: List<AccountEntity> = accountDao.getAccounts()
        if (localAccounts.isEmpty()) {
            addAllAccounts(remoteAccounts)
        }
    }

    private suspend fun addAllAccounts(remoteAccounts: List<Compte>) {
        var priority = 1
        for (remoteAccount in remoteAccounts) {
            val localAccount = AccountEntity(
                null,
                remoteAccount.code,
                remoteAccount.numero,
                remoteAccount.codeDevise,
                remoteAccount.typeCompte!!.code,
                remoteAccount.typeMembre!!.code,
                0.0,
                remoteAccount.intituleCompte,
                priority,
                remoteAccount.abonnementActif, 0
            )
            addAccountWithRelations(remoteAccount, localAccount)
            priority++
        }
    }

    private suspend fun addAccountWithRelations(
        compte: Compte, account: AccountEntity
    ) {
        val pays: Pays? = compte.agence!!.sfd!!.pays
        val rSfd: Sfd? = compte.agence!!.sfd
        val agence: Agence? = compte.agence

        // Check and insert Country
        val country = countryDao.getCountryByCode(pays!!.code) ?: run {
            countryDao.addCountry(CountryEntity(null, pays.code, pays.libelle))
            countryDao.getCountryByCode(pays.code)!!
        }

        // Check and insert SFD
        val sfd = sfdDao.getSFDByCode(rSfd!!.code) ?: run {
            sfdDao.addSFD(SFDEntity(0, rSfd.code, rSfd.libelle, rSfd.logo, country.countryId!!))
            sfdDao.getSFDByCode(rSfd.code)!!
        }

        // Check and insert Agency
        val agency = agencyDao.getAgencyByCode(agence!!.code) ?: run {
            agencyDao.addAgency(AgencyEntity(0, agence.code, agence.libelle, sfd.sfdId))
            agencyDao.getAgencyByCode(agence.code)!!
        }

        // Insert Account
        val accountWithAgencyId = account.copy(agencyId = agency.agencyId)
        return accountDao.addAccount(accountWithAgencyId)
    }

    private suspend fun addPersonneInfo(personneInfo: PersonneInfo) {
        print("Adding personne info")
        personInfoDao.addPersonInfo(
            PersonInfoEntity(
                null,
                personneInfo.code,
                personneInfo.prenom,
                personneInfo.nom
            )
        )
    }

    companion object {
        private const val MOCK_LOGIN_EMAIL = "sokkadaba"
        private const val MOCK_PASSWORD = "#Skadaba@98"
        private const val MOCK_DELAY = 1000L
    }
}