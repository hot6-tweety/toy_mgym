package com.toy.mgym

import com.toy.mgym.model.FoodData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET()
    fun getFoodData(
        // ServiceKey 는 local 에 숨겨놓았습니다.
        @Query("ServiceKey") serviceKey: String = BuildConfig.FOOD_API_ENCO_KEY,
        @Query("type") type: String = "json",
        @Query("desc_kor") foodName: String = "",
    ): FoodData

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