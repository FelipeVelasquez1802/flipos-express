package com.infinitesolutions.fliposexpress.data.api.retrofit

import com.infinitesolutions.fliposexpress.data.Constants.Companion.HOSTNAME
import com.infinitesolutions.fliposexpress.data.api.retrofit.dao.OrderDao
import com.infinitesolutions.fliposexpress.data.api.retrofit.dao.UserDao
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConf {
    companion object {

        private var retrofit: Retrofit? = null

        fun getRetrofit(): Retrofit {
            return if (retrofit != null) retrofit!!
            else {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val httpClient = OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                httpClient.addInterceptor(logging)
                Retrofit.Builder()
                    .baseUrl(HOSTNAME)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient.build())
                    .build()
            }
        }

        fun user(): UserDao = getRetrofit().create(UserDao::class.java)

        fun order(): OrderDao = getRetrofit().create(OrderDao::class.java)
    }
}