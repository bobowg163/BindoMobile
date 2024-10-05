package com.example.bindomobile.domain.repositories

import com.example.bindomobile.domain.models.feature_profile.CompactProfile

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:24
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 24
 */

interface ProfileRepository {
    suspend fun getCompactProfile(): CompactProfile
}