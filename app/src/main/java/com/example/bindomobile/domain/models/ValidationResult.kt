package com.example.bindomobile.domain.models

import com.example.bindomobile.domain.core.ErrorType

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:03
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 03
 */
data class ValidationResult(
    val isValid: Boolean,
    val validationError: ErrorType? = null
)