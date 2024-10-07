package com.example.bindomobile.domain.usecases.onboarding

import com.example.bindomobile.domain.repositories.AppSettignsRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午11:04
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 04
 */
class CheckIfPassedOnboardingUseCase(
    private val settingsRepository: AppSettignsRepository
) {
    fun execute(): Boolean {
        return settingsRepository.isOnboardingPassed()
    }
}