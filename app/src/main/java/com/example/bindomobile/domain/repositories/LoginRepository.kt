package com.example.bindomobile.domain.repositories

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:24
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 24
 */
interface LoginRepository {
    suspend fun login(username: String, password: String)
    suspend fun checkIfLoggedIn(): Boolean
    suspend fun logOut()
}