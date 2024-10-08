package com.example.bindomobile.domain.models.feature_cards

import com.example.bindomobile.domain.models.feature_account.MoneyAmount

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午4:55
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 55
 */

data class PaymentCard(
    val cardId: String,
    val isPrimary: Boolean,
    val cardNumber: String,
    val cardType: CardType,
    val cardHolder: String,
    val expiration: Long,
    val recentBalance: MoneyAmount,
    val addressFirstLine: String,
    val addressSecondLine: String,
    val addedDate: Long
)