package com.example.bindomobile.data.repositories

import com.cioccarellia.ksprefs.KsPrefs
import com.example.bindomobile.data.app.PrefKeys
import com.example.bindomobile.data.datasource.local.dao.PersonInfoDao
import com.example.bindomobile.domain.models.feature_profile.CompactProfile
import com.example.bindomobile.domain.repositories.ProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/17
 * @time 下午7:44
 * @month_full 十月
 * @day 17
 * @day_full 星期四
 * @minute 44
 */
class ProfileRepositoryMock(
    private val dispatcher: CoroutineDispatcher,
    private val personInfoDao: PersonInfoDao,
    private val prefs: KsPrefs
) : ProfileRepository {
    override suspend fun getCompactProfile(): CompactProfile = withContext(dispatcher) {
        delay(MOCK_DELAY)

        val personInfo = personInfoDao.getPersonInfos().first()

        return@withContext CompactProfile(
            id = prefs.pull(PrefKeys.USERNAME.name),
            firstName = personInfo.firstname,
            lastName = personInfo.lastname,
            nickname = buildNickname(personInfo.firstname, personInfo.lastname),
            email = "example@example.com",
            profilePicUrl = "https://api.dicebear.com/7.x/open-peeps/svg?seed=Bailey"
        )
    }

    companion object {
        private const val MOCK_DELAY = 300L
    }

    private fun buildNickname(firstname: String, lastname: String): String {
        return "@${firstname.lowercase()}${lastname.lowercase()}"
    }
}