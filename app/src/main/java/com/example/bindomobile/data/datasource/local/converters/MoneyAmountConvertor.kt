package com.example.bindomobile.data.datasource.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.bindomobile.domain.models.feature_account.MoneyAmount

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:29
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 29
 */
@ProvidedTypeConverter
class MoneyAmountConvertor {
    @TypeConverter
    fun moneyAmountToDb(value: MoneyAmount?): Float? {
        return value?.value
    }

    @TypeConverter
    fun moneyAmountFromDb(value: Float?): MoneyAmount? {
        return if (value != null) {
            MoneyAmount(value)
        }
        else {
            null
        }
    }
}