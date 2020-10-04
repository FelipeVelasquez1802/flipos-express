package com.infinitesolutions.dataaccess.repository.order

import android.content.Context
import com.infinitesolutions.dataaccess.anticorruption.OrderTranslator
import com.infinitesolutions.dataaccess.dto.OrderDto
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.repository.OrderRepository
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    @ActivityContext val context: Context
) : OrderRepository {

    private val orderTranslator by lazy { OrderTranslator() }

    override fun selectActiveByUser(userId: Int): List<Order> {
        val orders: List<OrderDto> = listOf(
            OrderDto(1, 1000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(2, 10000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(3, 91000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(4, 81000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(5, 81000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z")
        )
        //val orders: List<OrderDto> = listOf()
        return orderTranslator.fromDtoListToDomainList(orders)
    }

    override fun selectInactiveByUser(userId: Int): List<Order> {
        val orders: List<OrderDto> = listOf(
            OrderDto(1, 1000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(2, 10000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(3, 91000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(4, 81000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z"),
            OrderDto(5, 81000.0, 5000.0, "Esto es un ejemplo","2020-08-26T02:14:48.922771Z")
        )
        //val orders: List<OrderDto> = listOf()
        return orderTranslator.fromDtoListToDomainList(orders)
    }
}