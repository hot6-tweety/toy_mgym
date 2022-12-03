package com.toy.mgym

import android.R
import com.toy.mgym.model.FoodBody
import com.toy.mgym.model.FoodData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiClient {

    @GET("getFoodNtrItdntList1")
    suspend fun getFoodData(
        // serviceKey 는 local 에 숨김
        @Query("serviceKey") serviceKey: String = BuildConfig.FOOD_API_DECO_KEY,
        @Query("type") type: String = "json",
        @Query("desc_kor") foodName: String? = "김",
        @Query("numOfRows") searchCount: Int? = 1
    ): FoodBody
    // 안드로이드 Pie (9버전) 이후부터 https 를 사용, SSL 문제 발생, 임시로 http GET 요청하게끔 변경
    // TODO 트래픽량이 10000개 제한되어 있어서 SVC 파일을 DB에 저장하는 방식으로 변경해야함

    companion object {

        fun create(): ApiClient {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.FOOD_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }

    }
}