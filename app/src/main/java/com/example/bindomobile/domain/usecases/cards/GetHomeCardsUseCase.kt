package com.example.bindomobile.domain.usecases.cards

import com.example.bindomobile.domain.models.feature_cards.PaymentCard
import com.example.bindomobile.domain.repositories.CardsRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:24
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 24
 */
class GetHomeCardsUseCase(
    private val cardsRepository: CardsRepository
) {
    suspend fun execute(): List<PaymentCard> {
        val allCards =  cardsRepository.getCards()
        val (primary,other) = allCards.partition { it.isPrimary }
        val sortedPrimary = primary.sortedByDescending { it.addedDate }
        val sortedOther = other.sortedByDescending { it.addedDate }
        return (sortedPrimary + sortedOther).take(DISPLAYED_COUNT)
    }

    companion object {
        private const val DISPLAYED_COUNT = 3
    }
}