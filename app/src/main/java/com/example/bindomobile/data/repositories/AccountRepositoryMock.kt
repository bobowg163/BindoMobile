package com.example.bindomobile.data.repositories

import com.cioccarellia.ksprefs.KsPrefs
import com.example.bindomobile.data.datasource.local.dao.AccountDao
import com.example.bindomobile.data.datasource.local.dao.AgencyDao
import com.example.bindomobile.data.datasource.local.dao.CardsDao
import com.example.bindomobile.data.datasource.local.entities.AccountEntity
import com.example.bindomobile.data.datasource.remote.api.ClientApiService
import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import com.example.bindomobile.domain.repositories.AccountRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午4:45
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 45
 */
class AccountRepositoryMock(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val cardsDao: CardsDao,
    private val accountDao: AccountDao,
    private val agencyDao: AgencyDao,
    private val prefs: KsPrefs,
    private val api:ClientApiService
) : AccountRepository {
    override suspend fun getMainAccount(): AccountEntity {
        return accountDao.getAccountFilteredByPriority()!!.first()
    }

    override suspend fun getAccountById(accountId: String): AccountEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getAccounts(): List<AccountEntity> {
        TODO("Not yet implemented")
    }

    override fun getBalanceFlow(): Flow<MoneyAmount> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipient(recipientAccount: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun getCardBalanceFlow(cardId: String): Flow<MoneyAmount> {
        TODO("Not yet implemented")
    }

    companion object {
        private const val MOCK_DELAY = 500L
        private const val MOCK_OBSERVING = 5000L
    }

}