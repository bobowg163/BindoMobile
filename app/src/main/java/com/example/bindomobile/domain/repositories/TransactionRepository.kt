package com.example.bindomobile.domain.repositories

import androidx.paging.PagingData
import com.example.bindomobile.domain.models.feature_transactions.Transaction
import com.example.bindomobile.domain.models.feature_transactions.TransactionRowPayload
import com.example.bindomobile.domain.models.feature_transactions.TransactionStatus
import com.example.bindomobile.domain.models.feature_transactions.TransactionType
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:24
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 24
 */

interface TransactionRepository {
    suspend fun getTransactions(filterByType: TransactionType?): Flow<PagingData<Transaction>>
    fun getTransactionStatusFlow(transactionId: Long): Flow<TransactionStatus>
    suspend fun submitTransaction(payload: TransactionRowPayload)
}