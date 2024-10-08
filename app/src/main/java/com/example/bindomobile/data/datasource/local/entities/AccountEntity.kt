package com.example.bindomobile.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午12:57
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 57
 */
@Entity(
    tableName = "accounts",
    foreignKeys = [
        ForeignKey(
            entity = AgencyEntity::class,
            parentColumns = arrayOf("agencyId"),
            childColumns = arrayOf("agencyId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )]
)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val accountId: Long?,
    val code: String,
    val number: String,
    val currencyCode: String,
    val accountTypeCode: String,
    val memberTypeCode: String,
    var balance: Double = 0.0,
    val accountOwner: String,
    val priority: Int,
    val enabled: Boolean,
    val agencyId: Long,
)