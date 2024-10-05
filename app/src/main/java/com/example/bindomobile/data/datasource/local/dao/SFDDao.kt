package com.example.bindomobile.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bindomobile.data.datasource.local.entities.SFDEntity

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:34
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 34
 */
@Dao
interface SFDDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addSFD(sfd: SFDEntity)

    @Query("SELECT * FROM sfds")
    suspend fun getSFDs(): List<SFDEntity>

    @Query("SELECT * FROM sfds WHERE sfdId = (:id)")
    suspend fun getSFDById(id: Long): SFDEntity?

    @Query("SELECT * FROM sfds WHERE code = (:code)")
    suspend fun getSFDByCode(code: String): SFDEntity?

    @Delete
    suspend fun deleteSFD(sfd: SFDEntity)

    @Update
    suspend fun updateSFD(sfd: SFDEntity)

}