package com.example.bindomobile.ui.feature_app_lock.core

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/9
 * @time 下午9:46
 * @month_full 十月
 * @day 09
 * @day_full 星期三
 * @minute 46
 */
sealed class AppLockIntent {
    data class PinFieldChange(val pin: String): AppLockIntent()
    object BiometricsBtnClick: AppLockIntent()
}