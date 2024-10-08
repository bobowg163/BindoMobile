package com.example.bindomobile.domain.usecases.validation

import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.models.ValidationResult

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午8:13
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 13
 */
class ValidatePasswordUseCase {
    fun execute(password: String): ValidationResult {
        return if (isPasswordValid(password)) {
            ValidationResult(true, null)
        } else if (password.isBlank()) {
            ValidationResult(false, ErrorType.FIELD_IS_EMPTY)
        } else {
            ValidationResult(false, ErrorType.INVALID_PASSWORD_FIELD)
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        if (password.length < 6) return false
        if (password.firstOrNull { it.isDigit() } == null) return false
        if (password.firstOrNull { it.isLetter() } == null) return false
        return true
    }
}