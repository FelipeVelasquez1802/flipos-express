package com.infinitesolutions.dataaccess.repository.order

import com.infinitesolutions.dataaccess.anticorruption.OrderTranslator
import com.infinitesolutions.dataaccess.dto.OrderDto
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor() : OrderRepository {

    private val orderTranslator by lazy { OrderTranslator() }

    override fun selectByUser(userId: Int): List<Order> {
        val ordersDto = listOf(
            OrderDto(1, 5000.0, 5000.0, "El domicilio"),
            OrderDto(2, 15000.0, 5000.0, "El domicilio"),
            OrderDto(3, 25000.0, 5000.0, "El domicilio"),
            OrderDto(4, 35000.0, 5000.0, "El domicilio"),
            OrderDto(5, 15000.0, 5000.0, "El domicilio"),
            OrderDto(6, 8000.0, 5000.0, "El domicilio"),
            OrderDto(7, 55000.0, 5000.0, "El domicilio"),
            OrderDto(8, 115000.0, 5000.0, "El domicilio"),
            OrderDto(9, 35000.0, 5000.0, "El domicilio"),
            OrderDto(10, 25000.0, 5000.0, "El domicilio"),
            OrderDto(11, 45000.0, 5000.0, "El domicilio"),
            OrderDto(12, 65000.0, 5000.0, "El domicilio")
        )
        //val ordersDto: List<OrderDto> = listOf()
        return orderTranslator.fromDtoListToDomainList(ordersDto)
    }

}