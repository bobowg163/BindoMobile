package com.example.bindomobile.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bindomobile.domain.models.feature_cards.CardType

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:25
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 25
 */
@Entity(tableName = "cards_cache")
data class CardEntity(
    @PrimaryKey(autoGenerate = false)
    val number: String,
    val isPrimary: Boolean,
    val cardType: CardType,
    val recentBalance: Float,
    val cardHolder: String,
    val expiration: Long,
    val addressFirstLine: String,
    val addressSecondLine: String,
    val addedDate: Long,
)