package com.example.bindomobile.domain.usecases.validation

import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.models.ValidationResult

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午7:58
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 58
 */
class ValidateCardNumberUseCase {
    fun execute(cardNumber:String): ValidationResult{
        return if (cardNumber.isNotBlank()&&validateWithLuhnAlgorithm(cardNumber)){
            ValidationResult(true)
        }else{
           return if(cardNumber.isBlank()){
               ValidationResult(true, validationError = ErrorType.FIELD_IS_EMPTY)
           }else{
               ValidationResult(false, validationError = ErrorType.INVALID_CARD_NUMBER)
           }
        }
    }

    private fun validateWithLuhnAlgorithm(cardNumber: String):Boolean{
        var checkSum:Int = 0
        for (i in cardNumber.length -1 downTo 0 step 2){
            checkSum += cardNumber[i] - '0'
        }
        for (i in cardNumber.length -2 downTo 0 step 2){
            val n:Int = (cardNumber[i] - '0') * 2
            checkSum += if (n >9) n - 9 else n
        }
        return checkSum % 10 == 0
    }
}