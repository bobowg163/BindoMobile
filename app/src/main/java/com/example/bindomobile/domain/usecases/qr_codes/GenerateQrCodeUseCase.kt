package com.example.bindomobile.domain.usecases.qr_codes

import com.example.bindomobile.domain.models.feature_qr_codes.QrPurpose
import kotlinx.coroutines.delay

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/8
 * @time 下午7:19
 * @month_full 十月
 * @day 08
 * @day_full 星期二
 * @minute 19
 */
class GenerateQrCodeUseCase {
    suspend fun execute(qrPurpose: QrPurpose): String {
        delay(300L)
        return when (qrPurpose) {
            QrPurpose.PROFILE_CONNECTION -> "profile_connection"
        }
    }
}