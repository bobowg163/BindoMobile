package com.example.bindomobile.domain.usecases.profile

import com.example.bindomobile.domain.models.feature_profile.CompactProfile
import com.example.bindomobile.domain.repositories.ProfileRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午7:17
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 17
 */
class GetCompactProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend fun execute(): CompactProfile {
        return profileRepository.getCompactProfile()
    }
}