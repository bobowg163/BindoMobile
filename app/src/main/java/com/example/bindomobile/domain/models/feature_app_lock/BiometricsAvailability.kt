package com.example.bindomobile.domain.models.feature_app_lock

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午4:50
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 50
 */
sealed class BiometricsAvailability {
    object Checking:BiometricsAvailability()
    object Available:BiometricsAvailability()
    object NotAvailable:BiometricsAvailability()
    object NotEnabled:BiometricsAvailability()
}