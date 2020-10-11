package com.infinitesolutions.dataaccess.anticorruption

import com.infinitesolutions.dataaccess.dto.OrderDto
import com.infinitesolutions.domain.entity.Order

class OrderTranslator {

    fun fromDtoListToDomainList(ordersDto: List<OrderDto>): List<Order> =
        ordersDto.map {
            Order(
                it.id,
                it.cost,
                it.orderCost,
                it.description,
                it.userId,
                it.finishDate,
                finish = it.finish,
                cancel = it.cancel
            )
        }

    fun fromDomainListToDtoList(orders: List<Order>): List<OrderDto> =
        orders.map {
            OrderDto(
                it.id,
                it.cost,
                it.orderCost,
                it.description,
                it.userId,
                it.finishDate,
                finish = it.finish,
                cancel = it.cancel
            )
        }

    fun fromDtoToDomain(orderDto: OrderDto): Order =
        Order(
            orderDto.id,
            orderDto.cost,
            orderDto.orderCost,
            orderDto.description,
            orderDto.userId,
            orderDto.finishDate,
            finish = orderDto.finish,
            cancel = orderDto.cancel
        )

    fun fromDomainToDto(order: Order): OrderDto =
        OrderDto(
            order.id,
            order.cost,
            order.orderCost,
            order.description,
            order.userId,
            order.finishDate,
            finish = order.finish,
            cancel = order.cancel
        )
}