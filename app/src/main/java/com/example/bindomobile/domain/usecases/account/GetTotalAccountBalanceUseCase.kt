package com.example.bindomobile.domain.usecases.account

import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import com.example.bindomobile.domain.repositories.AccountRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:08
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 08
 */
class GetTotalAccountBalanceUseCase(
    private val accountRepository: AccountRepository
) {
    fun execute(): Flow<MoneyAmount> {
        return accountRepository.getBalanceFlow()
    }
}