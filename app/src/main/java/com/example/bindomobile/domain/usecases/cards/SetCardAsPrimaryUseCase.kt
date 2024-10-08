package com.example.bindomobile.domain.usecases.cards

import com.example.bindomobile.domain.repositories.CardsRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午10:29
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 29
 */
class SetCardAsPrimaryUseCase(
    private val cardsRepository: CardsRepository
) {
    suspend fun execute(cardId: String, setAsPrimary: Boolean) {
        return cardsRepository.markCardAsPrimary(cardId, setAsPrimary)
    }
}