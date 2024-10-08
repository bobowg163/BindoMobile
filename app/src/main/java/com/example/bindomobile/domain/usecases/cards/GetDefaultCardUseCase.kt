package com.example.bindomobile.domain.usecases.cards

import com.example.bindomobile.domain.models.feature_cards.PaymentCard
import com.example.bindomobile.domain.repositories.CardsRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:23
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 23
 */
class GetDefaultCardUseCase(
    private val cardsRepository: CardsRepository
) {
    suspend fun execute(): PaymentCard? {
        val cards = cardsRepository.getCards()
        return cards.find {
            it.isPrimary
        } ?: cards.firstOrNull()
    }
}