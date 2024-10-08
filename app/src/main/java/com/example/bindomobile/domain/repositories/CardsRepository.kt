package com.example.bindomobile.domain.repositories

import com.example.bindomobile.domain.models.feature_cards.AddCardPayload
import com.example.bindomobile.domain.models.feature_cards.PaymentCard

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:23
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 23
 */
interface CardsRepository {
    suspend fun getCards(): List<PaymentCard>
    suspend fun addCard(data: AddCardPayload)
    suspend fun getCardById(id: String): PaymentCard
    suspend fun deleteCardById(id: String)
    suspend fun markCardAsPrimary(cardId: String, isPrimary: Boolean = false)
}