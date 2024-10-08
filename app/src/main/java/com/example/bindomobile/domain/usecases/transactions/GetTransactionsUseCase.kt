package com.example.bindomobile.domain.usecases.transactions

import androidx.paging.PagingData
import com.example.bindomobile.domain.models.feature_transactions.Transaction
import com.example.bindomobile.domain.models.feature_transactions.TransactionType
import com.example.bindomobile.domain.repositories.TransactionRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午7:23
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 23
 */
class GetTransactionsUseCase(
    private val transactionsRepository: TransactionRepository
) {
    suspend fun execute(filterByType:TransactionType?):Flow<PagingData<Transaction>>{
        return transactionsRepository.getTransactions(filterByType)
    }
}