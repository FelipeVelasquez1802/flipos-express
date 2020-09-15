package com.infinitesolutions.dataaccess.repository

import com.infinitesolutions.dataaccess.Constant.Companion.LOGIN
import com.infinitesolutions.dataaccess.Constant.Companion.LOGOUT
import com.infinitesolutions.dataaccess.dto.TokenDto
import com.infinitesolutions.dataaccess.dto.UserDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {
    @POST(LOGIN)
    fun login(@Body user: UserDto): Call<TokenDto>

    @GET(LOGOUT)
    fun logout(@Header("Authorization") authorization: String): Call<Any>
}