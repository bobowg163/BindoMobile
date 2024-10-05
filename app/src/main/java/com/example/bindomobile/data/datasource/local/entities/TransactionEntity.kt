package com.example.bindomobile.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import com.example.bindomobile.domain.models.feature_transactions.TransactionStatus
import com.example.bindomobile.domain.models.feature_transactions.TransactionType

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:12
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 12
 */

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val type: TransactionType,
    val value: MoneyAmount,
    var recentStatus: TransactionStatus,
    val cardId: String="",
    val accountId: String="",
    val createdDate: Long,
    val updatedStatusDate: Long,
    val reference: String,
    val label:String,
)