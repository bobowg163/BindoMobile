package com.example.bindomobile.domain.usecases.validation

import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.models.ValidationResult

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午7:37
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 37
 */
class ValidateBillingAddressUseCase {
    fun execute(
        addressFirstLine: String,
        addressSecondLine: String,
    ): ValidationResult {
        return if (addressFirstLine.isBlank()) {
            ValidationResult(true, validationError = ErrorType.FIELD_IS_EMPTY)
        } else {
            ValidationResult(true, validationError = null)
        }
    }
}