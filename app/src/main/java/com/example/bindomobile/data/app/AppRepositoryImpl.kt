package com.example.bindomobile.data.app

import com.cioccarellia.ksprefs.KsPrefs
import com.example.bindomobile.domain.repositories.AppSettignsRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午8:29
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 29
 */
class AppRepositoryImpl(
    private val prefs:KsPrefs
):AppSettignsRepository {
    override fun setOnboardingPassed(viewed: Boolean) {
        prefs.push(PrefKeys.IS_WIZARD_VIEWED.name, viewed)
    }

    override fun isOnboardingPassed(): Boolean {
       return prefs.pull(PrefKeys.IS_WIZARD_VIEWED.name,false)
    }

    override fun isAppPermissionAlreadyAsked(permission: String): Boolean {
       val key ="${PrefKeys.PERMISSION_ASKED_FLAG_PREFIX}_${permission}"
        return prefs.pull(key,false)
    }

    override fun setPermissionAsked(permission: String, isAsked: Boolean) {
        val key = "${PrefKeys.PERMISSION_ASKED_FLAG_PREFIX}_${permission}"
        prefs.push(key,isAsked)
    }
}