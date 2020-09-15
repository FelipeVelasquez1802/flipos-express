package com.infinitesolutions.fliposexpress.data.api.retrofit.dao

import com.infinitesolutions.fliposexpress.data.Constants.Companion.BY_USER
import com.infinitesolutions.fliposexpress.data.Constants.Companion.ORDERS
import com.infinitesolutions.fliposexpress.data.Constants.Companion.USER_ID
import com.infinitesolutions.fliposexpress.data.entities.OrderEntity
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface OrderDao {

    @GET(BY_USER)
    fun orderByUser(@Path(USER_ID) userId: Int): Single<List<OrderEntity>>

    @POST(ORDERS)
    fun insertOrder(@Body order: OrderEntity): Single<List<OrderEntity>>
}