package com.infinitesolutions.fliposexpress.data.api.retrofit.dao

import com.infinitesolutions.fliposexpress.data.Constants.Companion.LOGIN
import com.infinitesolutions.fliposexpress.data.Constants.Companion.LOGOUT
import com.infinitesolutions.fliposexpress.data.entities.UserEntity
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserDao {

    @POST(LOGIN)
    fun login(@Body user: UserEntity): Single<Any?>

    @GET(LOGOUT)
    fun logout(@Header("Authorization") authorization: String): Single<Any?>
}