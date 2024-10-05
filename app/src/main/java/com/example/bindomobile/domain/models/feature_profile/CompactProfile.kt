package com.example.bindomobile.domain.models.feature_profile

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午4:56
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 56
 */
data class CompactProfile(
    val id: String,
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val email: String,
    val profilePicUrl: String
)
