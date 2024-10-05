package com.example.bindomobile.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bindomobile.data.datasource.local.entities.CountryEntity

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:33
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 33
 */
@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addCountry(country: CountryEntity)

    @Query("SELECT * FROM countries")
    suspend fun getCountries(): List<CountryEntity>

    @Query("SELECT * FROM countries WHERE code = (:code)")
    suspend fun getCountryByCode(code: String): CountryEntity?

    @Delete
    suspend fun deleteCountry(country: CountryEntity)

    @Update
    suspend fun updateCountry(country: CountryEntity)

}