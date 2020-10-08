package com.infinitesolutions.domain.repository

import com.infinitesolutions.domain.entity.Order

interface OrderRepository {
    fun selectActiveByUser(userId: Int): List<Order>
    fun selectInactiveByUser(userId: Int): List<Order>
    fun insert(order: Order): List<Order>
    fun updateFinish(orderId: Int): List<Order>
}