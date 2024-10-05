package com.example.bindomobile.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bindomobile.data.datasource.local.entities.TransactionEntity
import com.example.bindomobile.domain.models.feature_transactions.TransactionType

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:34
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 34
 */
@Dao
interface TransactionDao {
    @Query("SELECT * FROM transactions WHERE id = (:id)")
    suspend fun getTransaction(id: Long): TransactionEntity?

    @Query("SELECT * FROM transactions ORDER BY id DESC LIMIT :loadSize OFFSET :startPosition")
    suspend fun getTransactionList(startPosition: Int, loadSize: Int): List<TransactionEntity>

    @Query("SELECT * FROM transactions WHERE type = :filterType ORDER BY id DESC LIMIT :loadSize OFFSET :startPosition")
    suspend fun getTransactionList(filterType: TransactionType, startPosition: Int, loadSize: Int): List<TransactionEntity>

    @Insert
    suspend fun addTransaction(transactionEntity: TransactionEntity): Long

    @Update
    suspend fun updateTransaction(card: TransactionEntity)
}