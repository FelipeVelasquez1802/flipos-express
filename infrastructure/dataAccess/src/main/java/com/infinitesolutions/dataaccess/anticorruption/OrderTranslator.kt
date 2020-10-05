package com.infinitesolutions.dataaccess.anticorruption

import com.infinitesolutions.dataaccess.dto.OrderDto
import com.infinitesolutions.domain.entity.Order

class OrderTranslator {

    fun fromDtoListToDomainList(ordersDto: List<OrderDto>): List<Order> =
        ordersDto.map { Order(it.id, it.cost, it.orderCost, it.description, it.finishDate) }
}