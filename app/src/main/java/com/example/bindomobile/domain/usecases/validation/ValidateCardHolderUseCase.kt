package com.example.bindomobile.domain.usecases.validation

import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.models.ValidationResult

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午7:47
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 47
 */
class ValidateCardHolderUseCase {
    fun execute(cardHolder: String): ValidationResult {
        return if (cardHolder.isBlank()) {
            ValidationResult(true)
        }else {
            ValidationResult(false, validationError = ErrorType.FIELD_IS_EMPTY)
        }
    }
}