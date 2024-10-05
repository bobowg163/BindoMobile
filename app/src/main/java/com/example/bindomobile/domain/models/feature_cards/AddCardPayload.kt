package com.example.bindomobile.domain.models.feature_cards

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午4:51
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 51
 */
data class AddCardPayload(
    val cardNumber: String,
    val cardHolder: String,
    val addressFirstLine: String,
    val addressSecondLine: String,
    val cvvCode: String,
    val expirationDate: Long,
)