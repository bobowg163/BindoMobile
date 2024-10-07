package com.example.bindomobile.domain.usecases.account

import com.example.bindomobile.domain.repositories.AccountRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:07
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 07
 */
class GetRecipientByAccountUseCase(
    private val accountRepository: AccountRepository
) {
    suspend fun execute(account: String): String {
        return accountRepository.getRecipient(account)
    }
}