package com.example.bindomobile.domain.usecases.transactions

import com.example.bindomobile.domain.models.feature_transactions.TransactionStatus
import com.example.bindomobile.domain.repositories.TransactionRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午7:35
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 35
 */
class ObserveTransactionStatusUseCase(
    private val transactionRepository: TransactionRepository
) {
    fun execute(transactionId: Long): Flow<TransactionStatus> {
        return transactionRepository.getTransactionStatusFlow(transactionId)
    }
}