package com.example.bindomobile.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bindomobile.data.datasource.local.converters.MoneyAmountConvertor
import com.example.bindomobile.data.datasource.local.dao.AccountDao
import com.example.bindomobile.data.datasource.local.dao.AgencyDao
import com.example.bindomobile.data.datasource.local.dao.CardsDao
import com.example.bindomobile.data.datasource.local.dao.CountryDao
import com.example.bindomobile.data.datasource.local.dao.PersonInfoDao
import com.example.bindomobile.data.datasource.local.dao.SFDDao
import com.example.bindomobile.data.datasource.local.dao.TransactionDao
import com.example.bindomobile.data.datasource.local.entities.AccountEntity
import com.example.bindomobile.data.datasource.local.entities.AgencyEntity
import com.example.bindomobile.data.datasource.local.entities.CardEntity
import com.example.bindomobile.data.datasource.local.entities.CountryEntity
import com.example.bindomobile.data.datasource.local.entities.PersonInfoEntity
import com.example.bindomobile.data.datasource.local.entities.SFDEntity
import com.example.bindomobile.data.datasource.local.entities.TransactionEntity

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:24
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 24
 */
@Database(
    entities = [AccountEntity::class, AgencyEntity::class, CardEntity::class, CountryEntity::class, PersonInfoEntity::class, SFDEntity::class, TransactionEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(MoneyAmountConvertor::class)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun getAccountDao():AccountDao
    abstract fun getAgencyDao():AgencyDao
    abstract fun getCardsDao():CardsDao
    abstract fun getCountryDao():CountryDao
    abstract fun getPersonInfoDao():PersonInfoDao
    abstract fun getSfdDAO():SFDDao
    abstract fun getTransactionsDao():TransactionDao
}