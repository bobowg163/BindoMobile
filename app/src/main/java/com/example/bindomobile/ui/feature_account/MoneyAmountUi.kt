package com.example.bindomobile.ui.feature_account

import com.example.bindomobile.domain.models.feature_account.BalanceCurrency
import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/17
 * @time 下午8:42
 * @month_full 十月
 * @day 17
 * @day_full 星期四
 * @minute 42
 */
data class MoneyAmountUi(
    val amountStr:String
){
    companion object{
        fun mapFromDomain(balance: MoneyAmount): MoneyAmountUi {
            val symbols = DecimalFormatSymbols(Locale.getDefault())
            val decimalFormat = DecimalFormat("#,##0.##", symbols)
            decimalFormat.isGroupingUsed = false
            val formattedValue = decimalFormat.format(balance.value)


            // Add currency prefixes
            return when (balance.currency) {
                BalanceCurrency.RMB -> {
                    MoneyAmountUi("${formattedValue}F")
                }

                BalanceCurrency.USD -> {
                    MoneyAmountUi("$formattedValue$")
                }

                BalanceCurrency.EUR -> {
                    MoneyAmountUi("$formattedValue€")
                }
            }
        }

        fun mapFromDomainTwo(balance: MoneyAmount): MoneyAmountUi {
            val symbols = DecimalFormatSymbols(Locale.getDefault())
            val decimalFormat = DecimalFormat("#,##0.##", symbols)
            decimalFormat.isGroupingUsed = false
            val formattedValue = decimalFormat.format(balance.value)


            // Add currency prefixes
            return when (balance.currency) {
                BalanceCurrency.RMB -> {
                    MoneyAmountUi("$formattedValue XOF")
                }

                BalanceCurrency.USD -> {
                    MoneyAmountUi("$formattedValue USD")
                }

                BalanceCurrency.EUR -> {
                    MoneyAmountUi("$formattedValue EUR")
                }
            }
        }
    }
}
