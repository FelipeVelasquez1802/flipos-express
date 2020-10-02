package com.infinitesolutions.dataaccess.repository.order

import android.content.Context
import com.infinitesolutions.dataaccess.anticorruption.OrderTranslator
import com.infinitesolutions.dataaccess.base.LocalRoomDatabase
import com.infinitesolutions.dataaccess.base.RemoteRetrofit
import com.infinitesolutions.dataaccess.dto.OrderDto
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.exception.valuenull.IdNullException
import com.infinitesolutions.domain.exception.valuenull.OrdersNullException
import com.infinitesolutions.domain.repository.OrderRepository
import dagger.hilt.android.qualifiers.ActivityContext
import retrofit2.Response
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    @ActivityContext val context: Context
) : OrderRepository {

    companion object {
        private const val VALUE_ACTIVE = "True"
    }

    private val orderTranslator by lazy { OrderTranslator() }

    private var orderService = RemoteRetrofit.retrofit.create(OrderService::class.java)
    private var userService = LocalRoomDatabase.getDatabase(context).userDao()

    override fun selectByUser(userId: Int): List<Order> {
        val idUser = userService.selectId() ?: throw IdNullException()
        val call = orderService.selectByUser(idUser, VALUE_ACTIVE)
        val response: Response<List<OrderDto>> = call.execute()
        val ordersDto = response.body() ?: throw OrdersNullException()
        return orderTranslator.fromDtoListToDomainList(ordersDto)
    }

}