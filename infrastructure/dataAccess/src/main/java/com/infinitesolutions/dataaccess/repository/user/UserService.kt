package com.infinitesolutions.dataaccess.repository.user

import com.infinitesolutions.dataaccess.dto.TokenDto
import com.infinitesolutions.dataaccess.dto.UserDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    companion object {
        private const val AUTH_API = "api-auth/"
        private const val LOGIN = "${AUTH_API}login"
        private const val LOGOUT = "${AUTH_API}logout"
    }

    @POST(LOGIN)
    fun login(@Body user: UserDto): Call<TokenDto>

    @GET(LOGOUT)
    fun logout(@Header("Authorization") authorization: String): Call<Any>
}