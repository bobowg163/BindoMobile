package com.example.bindomobile.data.repositories

import com.example.bindomobile.domain.models.feature_cards.CardType

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/16
 * @time 下午7:27
 * @month_full 十月
 * @day 16
 * @day_full 星期三
 * @minute 27
 */
object MockCardConstants {
    private val cards:Map<String, CardType> = mapOf(
        // Mastercard
        "2298126833989874" to CardType.CREDIT,
        "5555555555554444" to CardType.DEBIT,
        // VISA
        "4111111111111111" to CardType.DEBIT,
        // Maestro
        "6304000000000000" to CardType.DEBIT
    )

    fun randomCard():Pair<String, CardType>{
        return cards.toList().random()
    }

    fun cardTypeByNumber(cardNumber: String): CardType? {
        return cards[cardNumber]
    }
}