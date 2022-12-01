package com.toy.mgym

import android.R
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
        @Query("desc_kor") foodName: String = "국수",
        @Query("numOfRows") searchCount: Int = 100
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

        /*fun setSSLOkHttp(builder: OkHttpClient.Builder): OkHttpClient.Builder {
            builder.sslSocketFactory(
                sslContext.socketFactory,
                tmf.trustManagers[0] as X509TrustManager
            )

            val cf = CertificateFactory.getInstance("X.509")
            val caInput: InputStream = BufferedInputStream(
                application.getResources().openRawResource(R.raw.kurento_certification)
            )
            val ca: Certificate
            ca = try {
                cf.generateCertificate(caInput)
            } finally {
                caInput.close()
            }

            val keyStoreType = KeyStore.getDefaultType()
            val keyStore = KeyStore.getInstance(keyStoreType)
            keyStore.load(null, null)
            keyStore.setCertificateEntry("ca", ca)

            val tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm()
            val tmf = TrustManagerFactory.getInstance(tmfAlgorithm)
            tmf.init(keyStore)

            val context = SSLContext.getInstance("TLS")
            context.init(null, tmf.trustManagers, null)
            return this.client.setSocket(context.socketFactory.createSocket())
        }*/
    }
}