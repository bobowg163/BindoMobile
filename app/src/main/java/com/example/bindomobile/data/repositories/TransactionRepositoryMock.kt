package com.example.bindomobile.data.repositories

import androidx.paging.PagingData
import androidx.work.WorkManager
import com.cioccarellia.ksprefs.KsPrefs
import com.example.bindomobile.data.datasource.local.dao.AccountDao
import com.example.bindomobile.data.datasource.local.dao.AgencyDao
import com.example.bindomobile.data.datasource.local.dao.TransactionDao
import com.example.bindomobile.data.datasource.remote.api.ClientApiService
import com.example.bindomobile.domain.models.feature_transactions.Transaction
import com.example.bindomobile.domain.models.feature_transactions.TransactionRowPayload
import com.example.bindomobile.domain.models.feature_transactions.TransactionStatus
import com.example.bindomobile.domain.models.feature_transactions.TransactionType
import com.example.bindomobile.domain.repositories.TransactionRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/17
 * @time 下午7:42
 * @month_full 十月
 * @day 17
 * @day_full 星期四
 * @minute 42
 */
class TransactionRepositoryMock(
    private val workManager: WorkManager,
    private val transactionDao: TransactionDao,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val accountDao: AccountDao,
    private val agencyDao: AgencyDao,
    private val prefs: KsPrefs,
    private val api: ClientApiService
) : TransactionRepository {
    override suspend fun getTransactions(filterByType: TransactionType?): Flow<PagingData<Transaction>> {
        TODO("Not yet implemented")
    }

    override fun getTransactionStatusFlow(transactionId: Long): Flow<TransactionStatus> {
        TODO("Not yet implemented")
    }

    override suspend fun submitTransaction(payload: TransactionRowPayload) {
        TODO("Not yet implemented")
    }


}