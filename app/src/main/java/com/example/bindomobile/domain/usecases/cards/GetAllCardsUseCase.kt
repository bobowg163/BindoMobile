package com.example.bindomobile.domain.usecases.cards

import com.example.bindomobile.domain.models.feature_cards.PaymentCard
import com.example.bindomobile.domain.repositories.CardsRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:19
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 19
 */
class GetAllCardsUseCase(
    private val cardsRepository: CardsRepository
) {
    suspend fun execute(): List<PaymentCard> {
        val all = cardsRepository.getCards()
        val primary = all.filter { it.isPrimary }.sortedByDescending { it.addedDate }
        val other = all.filter { !it.isPrimary }.sortedByDescending { it.addedDate }
        return primary + other
    }
}