package com.example.bindomobile.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:11
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 11
 */
@Entity(tableName = "persons_infos")
data class PersonInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val personId: Long?,
    val code: String,
    val firstname: String,
    val lastname: String
)
