package com.infinitesolutions.dataaccess.repository.order

import com.infinitesolutions.dataaccess.Constant.Companion.API_V
import com.infinitesolutions.dataaccess.dto.OrderDto
import retrofit2.Call
import retrofit2.http.*

interface OrderService {
    companion object {
        private const val ORDER = "${API_V}orders/"
        private const val USER_ID = "user_id"
        private const val FINISH = "finish"
        private const val BY_USER = "${ORDER}by_user/{$USER_ID}/{$FINISH}"
        private const val FINISH_ORDER = "finish_order/"
        private const val ORDER_ID = "order_id"
        private const val UPDATE_FINISH = "${ORDER}$FINISH_ORDER{$ORDER_ID}/"
    }

    @GET(BY_USER)
    fun selectByUser(@Path(USER_ID) userId: Int, @Path(FINISH) finish: String): Call<List<OrderDto>>

    @POST(ORDER)
    fun insert(@Body orderDto: OrderDto): Call<List<OrderDto>>

    @GET(UPDATE_FINISH)
    fun updateFinish(@Path(ORDER_ID) orderId: Int): Call<List<OrderDto>>

}