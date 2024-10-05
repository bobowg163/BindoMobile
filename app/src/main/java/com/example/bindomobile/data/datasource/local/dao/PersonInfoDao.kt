package com.example.bindomobile.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bindomobile.data.datasource.local.entities.PersonInfoEntity

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
interface PersonInfoDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addPersonInfo(personInfo: PersonInfoEntity)

    @Query("SELECT * FROM persons_infos")
    suspend fun getPersonInfos(): List<PersonInfoEntity>

    @Query("SELECT * FROM persons_infos WHERE code = (:code)")
    suspend fun getPersonInfoByCode(code: String): PersonInfoEntity?

    @Delete
    suspend fun deletePersonInfo(personInfo: PersonInfoEntity)

    @Update
    suspend fun updatePersonInfo(personInfo: PersonInfoEntity)

}