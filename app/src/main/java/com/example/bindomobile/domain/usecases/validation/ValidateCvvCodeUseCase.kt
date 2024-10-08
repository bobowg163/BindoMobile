package com.example.bindomobile.domain.usecases.validation

import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.models.ValidationResult

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午8:06
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 06
 */
class ValidateCvvCodeUseCase {
    fun execute(cvv: String): ValidationResult {
        return if (cvv.isBlank()) {
            ValidationResult(isValid = false, validationError = ErrorType.FIELD_IS_EMPTY)
        } else {
            val cvvPattern = "\\d{3,4}".toRegex()
            if (cvvPattern.matches(cvv)) {
                ValidationResult(isValid = true, validationError = null)
            } else {
                ValidationResult(isValid = false, validationError = ErrorType.INVALID_CVV)
            }
        }
    }
}