package com.example.bindomobile.data.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cioccarellia.ksprefs.KsPrefs
import com.example.bindomobile.data.app.PrefKeys
import com.example.bindomobile.data.datasource.local.dao.AccountDao
import com.example.bindomobile.data.datasource.local.dao.AgencyDao
import com.example.bindomobile.data.datasource.local.dao.TransactionDao
import com.example.bindomobile.data.datasource.local.entities.TransactionEntity
import com.example.bindomobile.data.datasource.remote.api.ClientApiService
import com.example.bindomobile.data.datasource.remote.dtos.Statement

import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import com.example.bindomobile.domain.models.feature_transactions.TransactionStatus
import com.example.bindomobile.domain.models.feature_transactions.TransactionType
import com.example.bindomobile.ui.core.extensions.convertDateToMillis


/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/17
 * @time 下午7:33
 * @month_full 十月
 * @day 17
 * @day_full 星期四
 * @minute 33
 */
class TransactionSource(
    private val transactionDao: TransactionDao,
    private val filterByType: TransactionType?,
    private val accountDao: AccountDao,
    private val agencyDao: AgencyDao,
    private val prefs: KsPrefs,
    private val api: ClientApiService
) : PagingSource<Int, TransactionEntity>() {
    override fun getRefreshKey(state: PagingState<Int, TransactionEntity>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TransactionEntity> {
        return try {
            val currentPage = params.key ?: 1

            val transactions = loadFromDbCache(
                filterByType = filterByType,
                params = params
            )

            LoadResult.Page(
                data = transactions,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (transactions.size < params.loadSize) null else currentPage + 1
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    private suspend fun loadFromDbCache(
        filterByType: TransactionType?,
        params: LoadParams<Int>,
    ): List<TransactionEntity> {
        val currentPage = params.key ?: 1
        val startPosition = (currentPage - 1) * params.loadSize

        val statements = getFromRemote()

        return when (filterByType) {
            null -> return statements

            TransactionType.RECEIVE -> return statements.filter { it.type == TransactionType.RECEIVE }

            TransactionType.SEND -> return statements.filter { it.type == TransactionType.SEND }

            else -> transactionDao.getTransactionList(
                filterType = filterByType,
                startPosition = startPosition,
                loadSize = params.loadSize
            )
        }
    }

    private suspend fun getFromRemote(): List<TransactionEntity> {
        //Get the main account
        val mainAccount = accountDao.getAccountFilteredByPriority()!!.first()
        val agency = agencyDao.getAgencyById(mainAccount.agencyId)!!

        val token = prefs.pull<String>(PrefKeys.USER_TOKEN.name)

        val statementResponse = api.statement(token, agency.code, mainAccount.number)
        if (statementResponse.isSuccessful && statementResponse.body() != null) {
            val response = statementResponse.body()!!
            if (response.code == 0) {
                return this.mapStatementsToTransactionEntities(response.statements!!)
            }
        }
        return emptyList()
    }

    private fun mapStatementsToTransactionEntities(statements: List<Statement>): List<TransactionEntity> {
        return statements.map { statement ->
            TransactionEntity(
                type = if (statement.amount < 0) TransactionType.SEND else TransactionType.RECEIVE,
                value = MoneyAmount(statement.amount.toFloat()),
                recentStatus = TransactionStatus.COMPLETED,
                cardId = "1", // TODO
                createdDate = statement.valueDateText.convertDateToMillis(),
                updatedStatusDate = System.currentTimeMillis(),
                reference = statement.reference,
                label = statement.label
            ).apply {
                //TODO
            }
        }
    }
}