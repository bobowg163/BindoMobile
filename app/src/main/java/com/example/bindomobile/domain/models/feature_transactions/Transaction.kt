package com.example.bindomobile.domain.models.feature_transactions

import com.example.bindomobile.domain.models.feature_account.MoneyAmount

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:13
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 13
 */
data class Transaction(
    val id: Long,
    val type: TransactionType,
    val label: String,
    val value: MoneyAmount,
    val recentStatus: TransactionStatus,
    val createdDate: Long,
    val updatedStatusDate: Long,
)