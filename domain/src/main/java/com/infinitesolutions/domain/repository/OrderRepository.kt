package com.infinitesolutions.domain.repository

import com.infinitesolutions.domain.entity.Order

interface OrderRepository {
    fun selectByUser(userId: Int): List<Order>
}