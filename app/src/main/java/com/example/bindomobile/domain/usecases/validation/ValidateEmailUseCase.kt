package com.example.bindomobile.domain.usecases.validation

import android.util.Patterns
import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.models.ValidationResult

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午8:09
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 09
 */
class ValidateEmailUseCase {
    fun execute(email: String): ValidationResult{
        return if (email.isNotBlank()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            ValidationResult(true, null)
        }else if (email.isBlank()){
            ValidationResult(false, ErrorType.FIELD_IS_EMPTY)
        }else {
            ValidationResult(false, ErrorType.INVALID_EMAIL_FIELD)
        }
    }
}