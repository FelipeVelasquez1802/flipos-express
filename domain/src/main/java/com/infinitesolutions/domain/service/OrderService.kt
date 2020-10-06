package com.infinitesolutions.domain.service

import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.repository.OrderRepository
import javax.inject.Inject

class OrderService @Inject constructor(private val orderRepository: OrderRepository) {

    fun selectOrderActive(userId: Int): List<Order> = orderRepository.selectActiveByUser(userId)

    fun selectOrderInactive(userId: Int): List<Order> = orderRepository.selectInactiveByUser(userId)

    fun insert(order: Order): Order = orderRepository.insert(order)
}