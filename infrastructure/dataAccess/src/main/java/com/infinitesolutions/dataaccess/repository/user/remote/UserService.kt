package com.infinitesolutions.dataaccess.repository.user.remote

import com.infinitesolutions.dataaccess.Constant.Companion.API_V
import com.infinitesolutions.dataaccess.dto.TokenDto
import com.infinitesolutions.dataaccess.dto.remote.UserDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    companion object {
        private const val AUTH_API = "api-auth/"
        private const val USERS = "users/"
        private const val LOGIN = "${AUTH_API}login"
        private const val LOGOUT = "${AUTH_API}logout"
        private const val IS_LOGIN = "${API_V}${USERS}is_login"
    }

    @POST(LOGIN)
    fun login(@Body user: UserDto): Call<TokenDto>

    @GET(LOGOUT)
    fun logout(@Header("Authorization") authorization: String): Call<Any>

    @GET(IS_LOGIN)
    fun isLogin(@Header("Authorization") authorization: String): Call<TokenDto>


}