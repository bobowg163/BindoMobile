package com.example.bindomobile.ui.feature_app_lock.core

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/9
 * @time 下午9:49
 * @month_full 十月
 * @day 09
 * @day_full 星期三
 * @minute 49
 */
interface AppLockViewModel {
    val pinLength: Int
    fun emitAppLockIntent(intent: AppLockIntent)
}