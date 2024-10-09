package com.example.bindomobile.ui.feature_app_lock.core.biometrics

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import com.example.bindomobile.R

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/9
 * @time 下午8:48
 * @month_full 十月
 * @day 09
 * @day_full 星期三
 * @minute 48
 */
object BiometricsHelper {
    fun checkIfBiometricsAvailable(context: Context): Int {
        val biometricManager = BiometricManager.from(context)
        return biometricManager.canAuthenticate(Authenticators.BIOMETRIC_STRONG or Authenticators.BIOMETRIC_WEAK)
    }


    fun showPrompt(
        activity: FragmentActivity,
        prompt: BiometricsPromptUi,
        onSuccess: () -> Unit,
        onError: (error: String) -> Unit,
    ) {
        val biometricPrompt = BiometricPrompt(activity, object : BiometricPrompt.AuthenticationCallback() {
            // Called when an unrecoverable error has been encountered and authentication has stopped.
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                onError.invoke(activity.getString(R.string.error_template, errString))
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onSuccess.invoke()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                onError.invoke(activity.getString(R.string.error_auth_failed))
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(prompt.title.asString(activity))
            .setNegativeButtonText(prompt.cancelBtnText.asString(activity))
            .build()
        biometricPrompt.authenticate(promptInfo)
    }

}