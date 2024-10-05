package com.example.bindomobile.domain.repositories

import com.example.bindomobile.domain.models.feature_app_lock.AuthenticationResult
import com.example.bindomobile.domain.models.feature_app_lock.BiometricsAvailability

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:18
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 18
 */
interface AppLockRepository {
    fun setupAppLock(pinCode: String)
    fun authenticateWithPin(pin: String): AuthenticationResult
    fun checkIfAppLocked(): Boolean
    fun checkBiometricsAvailable(): BiometricsAvailability
    fun setupLockWithBiometrics(isLocked: Boolean)
    fun checkIfAppLockedWithBiometrics(): Boolean
}