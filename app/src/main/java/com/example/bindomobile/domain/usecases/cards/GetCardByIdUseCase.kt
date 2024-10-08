package com.example.bindomobile.domain.usecases.cards

import com.example.bindomobile.domain.models.feature_cards.PaymentCard
import com.example.bindomobile.domain.repositories.CardsRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:22
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 22
 */
class GetCardByIdUseCase(
    private val cardsRepository: CardsRepository
) {
    suspend fun execute(cardId: String): PaymentCard {
        return cardsRepository.getCardById(cardId)
    }
}