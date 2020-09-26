package com.infinitesolutions.domain.service

import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.repository.OrderRepository
import javax.inject.Inject

class OrderService @Inject constructor(private val orderRepository: OrderRepository) {

    fun selectOrder(userId: Int): List<Order> = orderRepository.selectByUser(userId)
}