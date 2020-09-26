package com.infinitesolutions.dataaccess.repository.order

import com.infinitesolutions.dataaccess.Constant.Companion.API_V
import com.infinitesolutions.dataaccess.dto.OrderDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OrderService {
    companion object {
        private const val ORDER = "${API_V}orders/"
        private const val BY_USER = "${ORDER}by_user/{userId}"
        private const val USER_ID = "user_id"
    }

    @GET(BY_USER)
    fun selectByUser(@Path(USER_ID) userId: Int): Call<List<OrderDto>>

}