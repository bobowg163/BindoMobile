package com.example.bindomobile.domain.models.feature_account

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:15
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 15
 */
data class MoneyAmount(
    val value: Float,
    val currency: BalanceCurrency = BalanceCurrency.RMB,
) {
    operator fun plus(other: MoneyAmount): MoneyAmount {
        return this.copy(value = this.value + other.value)
    }

    operator fun minus(other: MoneyAmount): MoneyAmount {
        return this.copy(value = this.value - other.value)
    }

    operator fun compareTo(other: MoneyAmount): Int {
        return this.value.compareTo(other.value)
    }
}