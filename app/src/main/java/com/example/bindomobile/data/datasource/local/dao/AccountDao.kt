package com.example.bindomobile.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bindomobile.data.datasource.local.entities.AccountEntity

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
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addAccount(account: AccountEntity)

    @Query("SELECT * FROM accounts ORDER by number")
    suspend fun getAccounts(): List<AccountEntity>

    @Query("SELECT * FROM accounts WHERE number = (:number)")
    suspend fun getAccountByNumber(number: String): AccountEntity?

    @Query("SELECT * FROM accounts WHERE code = (:code)")
    suspend fun getAccountByCode(code: String): AccountEntity?

    @Query("SELECT * FROM accounts ORDER BY priority ASC")
    suspend fun getAccountFilteredByPriority(): List<AccountEntity>?

    @Delete
    suspend fun deleteAccount(account: AccountEntity)

    @Update
    suspend fun updateAccount(account: AccountEntity)

}