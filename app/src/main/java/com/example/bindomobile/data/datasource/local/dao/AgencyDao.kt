package com.example.bindomobile.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bindomobile.data.datasource.local.entities.AgencyEntity

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:31
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 31
 */
@Dao
interface AgencyDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addAgency(agency: AgencyEntity)

    @Query("SELECT * FROM agencies")
    suspend fun getAgencies(): List<AgencyEntity>

    @Query("SELECT * FROM agencies WHERE code = (:code)")
    suspend fun getAgencyByCode(code: String): AgencyEntity?

    @Query("SELECT * FROM agencies WHERE agencyId = (:id)")
    suspend fun getAgencyById(id: Long): AgencyEntity?

    @Delete
    suspend fun deleteAgency(agency: AgencyEntity)

    @Update
    suspend fun updateAgency(agency: AgencyEntity)

}