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
class ValidateLoginUseCase {
    fun execute(login: String): ValidationResult {
        return if (isLoginValid(login)) {
            ValidationResult(true, null)
        } else if (login.isBlank()) {
            ValidationResult(false, ErrorType.FIELD_IS_EMPTY)
        } else {
            ValidationResult(false, ErrorType.INVALID_LOGIN_FIELD)
        }
    }

    private fun isLoginValid(login: String): Boolean {
        if (login.length < 3) return false
//        if (login.firstOrNull { it.isDigit() } == null) return false
//        if (login.firstOrNull { it.isLetter() } == null) return false

        return true
    }
}