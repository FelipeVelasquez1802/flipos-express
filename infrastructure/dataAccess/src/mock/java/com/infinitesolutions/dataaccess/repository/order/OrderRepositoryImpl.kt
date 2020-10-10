package com.infinitesolutions.dataaccess.repository.order

import com.infinitesolutions.dataaccess.anticorruption.OrderTranslator
import com.infinitesolutions.dataaccess.dto.OrderDto
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor() : OrderRepository {

    private val orderTranslator by lazy { OrderTranslator() }

    companion object {
        private val ORDES: List<OrderDto> = listOf(
            OrderDto(1, 1000.0, 5000.0, "Esto es un ejemplo", 1, "2020-08-26T02:14:48.922771Z"),
            OrderDto(2, 10000.0, 5000.0, "Esto es un ejemplo", 1, "2020-08-26T02:14:48.922771Z"),
            OrderDto(3, 91000.0, 5000.0, "Esto es un ejemplo", 1, "2020-08-26T02:14:48.922771Z"),
            OrderDto(4, 81000.0, 5000.0, "Esto es un ejemplo", 1, "2020-08-26T02:14:48.922771Z"),
            OrderDto(5, 81000.0, 5000.0, "Esto es un ejemplo", 1, "2020-08-26T02:14:48.922771Z")
        )

        //private val ORDERS: List<OrderDto> = listOf()
    }

    override fun selectActiveByUser(userId: Int): List<Order> =
        orderTranslator.fromDtoListToDomainList(ORDES)

    override fun selectInactiveByUser(userId: Int): List<Order> =
        orderTranslator.fromDtoListToDomainList(ORDES)

    override fun insert(order: Order): List<Order> {
        val orderDto = orderTranslator.fromDomainToDto(order)
        return orderTranslator.fromDtoListToDomainList(ORDES.plus(orderDto))
    }

    override fun updateFinish(orderId: Int): List<Order> {
        val orders = ORDES.filter { it.id != orderId }
        return orderTranslator.fromDtoListToDomainList(orders)
    }

    override fun updateCancel(orderId: Int): List<Order> {
        val orders = ORDES.filter { it.id != orderId }
        return orderTranslator.fromDtoListToDomainList(orders)
    }
}