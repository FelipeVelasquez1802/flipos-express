package com.infinitesolutions.domain.service

import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.exception.BadUserIdException
import com.infinitesolutions.domain.exception.badid.BadOrderIdException
import com.infinitesolutions.domain.repository.OrderRepository
import javax.inject.Inject

class OrderService @Inject constructor(private val orderRepository: OrderRepository) {

    fun selectOrderActive(userId: Int): List<Order> {
        if (userId < 1) throw BadUserIdException()
        return orderRepository.selectActiveByUser(userId)
    }

    fun selectOrderInactive(userId: Int): List<Order> {
        if (userId < 1) throw BadUserIdException()
        return orderRepository.selectInactiveByUser(userId)
    }

    fun insert(cost: String, orderCost: String, description: String, userId: Int): List<Order> {
        val order = Order(cost, orderCost, description, userId)
        return orderRepository.insert(order)
    }

    fun updateFinish(orderId: Int, userId: Int): List<Order> {
        if (orderId < 1) throw BadOrderIdException()
        return orderRepository.updateFinish(orderId, userId)
    }
}