package com.example.bindomobile.data.app_lock

import android.content.Context
import android.content.SharedPreferences
import android.util.Base64
import com.example.bindomobile.domain.models.feature_app_lock.AuthenticationResult
import com.example.bindomobile.domain.models.feature_app_lock.BiometricsAvailability
import com.example.bindomobile.domain.repositories.AppLockRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午8:59
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 59
 */
class AppLockRepositoryImpl(
    private val securedPreferences: SharedPreferences,
    private val context: Context
): AppLockRepository {
    override fun setupAppLock(pinCode: String) {
       savePin(pin=pinCode)
    }
    private fun savePin(pin:String){
        val salt = CryptoUtils.generateSalt()
        val secretKey = CryptoUtils.generatePbkdf2Key(pin.toCharArray(),salt)

        val encodedPinData = Base64.encodeToString(secretKey.encoded, Base64.DEFAULT)
        val encodedSalt = Base64.encodeToString(salt, Base64.DEFAULT)

        securedPreferences.edit()
            .putString(PIN_KEY, encodedPinData)
            .putString(PIN_SALT_KEY, encodedSalt)
            .apply()
    }
    override fun authenticateWithPin(pin: String): AuthenticationResult {
        TODO("Not yet implemented")
    }

    override fun checkIfAppLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun checkBiometricsAvailable(): BiometricsAvailability {
        TODO("Not yet implemented")
    }

    override fun setupLockWithBiometrics(isLocked: Boolean) {
        TODO("Not yet implemented")
    }

    override fun checkIfAppLockedWithBiometrics(): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        private const val PIN_KEY = "PIN_KEY"
        private const val PIN_SALT_KEY = "PIN_SALT"
        private const val BIOMETRICS_FLAG = "BIOMETRICS_LOCK_ENABLED"
    }
}