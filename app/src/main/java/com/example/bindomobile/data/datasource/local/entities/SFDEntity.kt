package com.example.bindomobile.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
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
@Entity(
    tableName = "sfds",
    foreignKeys = [
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = arrayOf("countryId"),
            childColumns = arrayOf("countryId"),
            onUpdate = ForeignKey.CASCADE,
        )]
)
data class SFDEntity(
    @PrimaryKey(autoGenerate = true)
    val sfdId: Long = 0,
    val code: String,
    val label: String,
    val logo: String,
    val countryId: Long
)