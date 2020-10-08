package com.infinitesolutions.dataaccess.base

import com.infinitesolutions.dataaccess.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRetrofit {
    companion object {
        private const val HOSTNAME = BuildConfig.HOSTNAME
        private val logging = HttpLoggingInterceptor()
            get() {
                field.level = HttpLoggingInterceptor.Level.BODY
                return field
            }
        private val httpClient = OkHttpClient.Builder()
            get() {
                field.addInterceptor(logging)
                return field
            }
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(HOSTNAME)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }
}