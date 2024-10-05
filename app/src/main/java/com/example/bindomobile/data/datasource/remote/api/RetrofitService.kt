package com.example.bindomobile.data.datasource.remote.api

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午2:19
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 19
 */
object RetrofitService {
    private const val BASE_URL = "https://www.ebindoo.com/digicom/rs/ebanking/"
    val api: ClientApiService by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .build().create(ClientApiService::class.java)
    }
}