package com.example.bindomobile.data.repositories

import com.example.bindomobile.data.datasource.local.dao.CardsDao
import com.example.bindomobile.data.datasource.local.entities.CardEntity
import com.example.bindomobile.domain.core.AppError
import com.example.bindomobile.domain.core.ErrorType
import com.example.bindomobile.domain.models.feature_account.MoneyAmount
import com.example.bindomobile.domain.models.feature_cards.AddCardPayload
import com.example.bindomobile.domain.models.feature_cards.CardType
import com.example.bindomobile.domain.models.feature_cards.PaymentCard
import com.example.bindomobile.domain.repositories.CardsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/16
 * @time 下午7:09
 * @month_full 十月
 * @day 16
 * @day_full 星期三
 * @minute 09
 */
class CardsRepositoryMock(
    private val cardsDao: CardsDao,
    private val coroutineDispatcher: CoroutineDispatcher
) : CardsRepository {
    override suspend fun getCards(): List<PaymentCard> = withContext(coroutineDispatcher) {
        delay(MOCK_DELAY)
        return@withContext cardsDao.getCards().map { mapCachedCardToDomain(it) }
    }

    override suspend fun addCard(data: AddCardPayload) = withContext(coroutineDispatcher) {
        val card = cardsDao.getCardByNumber(data.cardNumber)
        if (card != null) {
            delay(MOCK_DELAY)
            val entity = mapAddCardPayloadToCache(data)
            cardsDao.addCard(entity)
        }else{
            throw AppError(ErrorType.CARD_ALREADY_ADDED)
        }

    }
    override suspend fun getCardById(id: String): PaymentCard = withContext(coroutineDispatcher) {
        val cardEntity = cardsDao.getCardByNumber(id)?:throw AppError(ErrorType.CARD_NOT_FOUND)
        delay(MOCK_DELAY)
        return@withContext mapCachedCardToDomain(cardEntity)
    }

    override suspend fun deleteCardById(id: String) {
       val cardEntity = cardsDao.getCardByNumber(id)?:throw AppError(ErrorType.CARD_NOT_FOUND)
        delay(MOCK_DELAY)
        cardsDao.deleteCard(cardEntity)
    }

    override suspend fun markCardAsPrimary(cardId: String, isPrimary: Boolean) {
        when(isPrimary){
           true -> cardsDao.markCardAsPrimary(cardId)
            false -> cardsDao.unmarkCardAsPrimary(cardId)
        }
    }

    private fun mapCachedCardToDomain(cardEntity: CardEntity) = PaymentCard(
        cardId = cardEntity.number,
        cardNumber = cardEntity.number,
        isPrimary = cardEntity.isPrimary,
        cardHolder = cardEntity.cardHolder,
        addressFirstLine = cardEntity.addressFirstLine,
        addressSecondLine = cardEntity.addressSecondLine,
        expiration = cardEntity.expiration,
        recentBalance = MoneyAmount(cardEntity.recentBalance),
        cardType = cardEntity.cardType,
        addedDate = cardEntity.addedDate

    )
    private fun mapAddCardPayloadToCache(addCardPayload: AddCardPayload): CardEntity {
        val type = MockCardConstants.cardTypeByNumber(addCardPayload.cardNumber) ?: CardType.DEBIT
        return CardEntity(
            number = addCardPayload.cardNumber,
            isPrimary = false,
            cardHolder = addCardPayload.cardHolder,
            addressFirstLine = addCardPayload.addressFirstLine,
            addressSecondLine = addCardPayload.addressSecondLine,
            expiration = addCardPayload.expirationDate,
            addedDate = System.currentTimeMillis(),
            recentBalance = MOCK_CARD_INITIAL_BALANCE,
            cardType = type
        )
    }


    companion object {
        private const val MOCK_DELAY = 500L
        private const val MOCK_CARD_INITIAL_BALANCE = 0f
    }

}