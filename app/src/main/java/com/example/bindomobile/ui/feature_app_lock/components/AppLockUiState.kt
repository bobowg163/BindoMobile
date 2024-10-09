package com.example.bindomobile.ui.feature_app_lock.components

import com.example.bindomobile.ui.core.resources.UiText

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/9
 * @time 下午9:51
 * @month_full 十月
 * @day 09
 * @day_full 星期三
 * @minute 51
 */
data class AppLockUiState(
    val prompt:UiText = UiText.DynamicString(""),
    val pinLength: Int = 4,
    val pinValue:String = "",
    val error:UiText? = null,
    val isLocked:Boolean = false,
    val showBiometricsBtn:Boolean = false
)