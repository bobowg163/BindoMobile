package com.example.bindomobile.domain.repositories

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:22
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 22
 */


interface AppSettignsRepository {
    fun setOnboardingPassed(viewed: Boolean)

    fun isOnboardingPassed(): Boolean

    fun isAppPermissionAlreadyAsked(permission: String): Boolean

    fun setPermissionAsked(permission: String, isAsked: Boolean = true)
}