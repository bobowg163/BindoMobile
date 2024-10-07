package com.example.bindomobile.domain.usecases.account

import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import com.example.bindomobile.domain.models.feature_transactions.TransactionRowPayload
import com.example.bindomobile.domain.models.feature_transactions.TransactionType
import com.example.bindomobile.domain.repositories.TransactionRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:10
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 10
 */
class SendMoneyUseCase(
    private val transactionRepository: TransactionRepository
) {
    suspend fun execute(
        amount: MoneyAmount,
        fromAccountId: String,
        recipientId: String,
        comment: String
    ){
        return transactionRepository.submitTransaction(
            TransactionRowPayload(
                type = TransactionType.SEND,
                amount = amount,
                accountId = fromAccountId,
                destinationId = recipientId,
                comment = comment
            )
        )
    }
}