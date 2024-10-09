package com.example.bindomobile.ui.feature_app_lock.core.biometrics

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/9
 * @time 下午9:40
 * @month_full 十月
 * @day 09
 * @day_full 星期三
 * @minute 40
 */
sealed class BiometricAuthResult {
    object Success: BiometricAuthResult()
    data class Failure(val error: String): BiometricAuthResult()

}