package com.example.bindomobile.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:10
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 10
 */

@Entity(tableName = "countries")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val countryId: Long?,
    val code: String,
    val label: String
)