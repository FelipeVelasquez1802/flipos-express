package com.infinitesolutions.dataaccess.base

import com.infinitesolutions.dataaccess.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRetrofit {
    companion object {
        private const val HOSTNAME = BuildConfig.HOSTNAME
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(HOSTNAME)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}