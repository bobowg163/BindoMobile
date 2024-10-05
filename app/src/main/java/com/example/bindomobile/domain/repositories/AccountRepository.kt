package com.example.bindomobile.domain.repositories

import com.example.bindomobile.data.datasource.local.entities.AccountEntity
import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:12
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 12
 */
interface AccountRepository {
    suspend fun getMainAccount(): AccountEntity
    suspend fun getAccountById(accountId: String): AccountEntity
    suspend fun getAccounts(): List<AccountEntity>
    fun getBalanceFlow(): Flow<MoneyAmount>

    suspend fun getRecipient(recipientAccount: String): String
    suspend fun getCardBalanceFlow(cardId: String): Flow<MoneyAmount>
}