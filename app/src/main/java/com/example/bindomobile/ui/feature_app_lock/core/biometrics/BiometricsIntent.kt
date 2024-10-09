package com.example.bindomobile.ui.feature_app_lock.core.biometrics

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/9
 * @time 下午9:42
 * @month_full 十月
 * @day 09
 * @day_full 星期三
 * @minute 42
 */
sealed class BiometricsIntent {
    object RefreshBiometricsAvailability: BiometricsIntent()
    data class ConsumeAuthResult(val result: BiometricAuthResult): BiometricsIntent()
}