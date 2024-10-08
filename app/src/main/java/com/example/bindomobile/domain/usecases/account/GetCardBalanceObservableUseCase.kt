package com.example.bindomobile.domain.usecases.account

import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import com.example.bindomobile.domain.repositories.AccountRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午9:55
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 55
 */
class GetCardBalanceObservableUseCase(
    private val accountRepository: AccountRepository
) {
    suspend fun execute(cardId: String): Flow<MoneyAmount> {
        return accountRepository.getCardBalanceFlow(cardId)
    }
}