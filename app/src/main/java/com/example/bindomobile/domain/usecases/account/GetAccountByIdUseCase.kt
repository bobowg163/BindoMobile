package com.example.bindomobile.domain.usecases.account

import com.example.bindomobile.data.datasource.local.entities.AccountEntity
import com.example.bindomobile.domain.repositories.AccountRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午9:53
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 53
 */
class GetAccountByIdUseCase(
    private val accountRepository: AccountRepository
) {
    suspend fun execute(accountId: String): AccountEntity {
        return accountRepository.getAccountById(accountId)
    }
}