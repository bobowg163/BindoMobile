package com.example.bindomobile.domain.usecases.feature_app_lock

import com.example.bindomobile.domain.repositories.AppLockRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:54
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 54
 */
class CheckAppLockUseCase(
    private val appLockRepository: AppLockRepository
) {
    fun execute(): Boolean {
        return appLockRepository.checkIfAppLocked()
    }
}