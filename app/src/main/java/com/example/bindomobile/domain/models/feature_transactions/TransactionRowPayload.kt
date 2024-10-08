package com.example.bindomobile.domain.models.feature_transactions

import com.example.bindomobile.domain.models.feature_account.MoneyAmount

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:02
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 02
 */

data class TransactionRowPayload(
    val type: TransactionType,
    val amount: MoneyAmount,
    val accountId: String,
    val destinationId: String = "",
    val comment: String = ""
)