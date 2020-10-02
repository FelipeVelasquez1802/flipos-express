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

    companion object {
        private const val VALUE_ACTIVE = "True"
    }

    private val orderTranslator by lazy { OrderTranslator() }

    override fun selectByUser(userId: Int): List<Order> {
        val orders: List<OrderDto> = listOf(
            OrderDto(1,1000.0,5000.0, "Esto es un ejemplo")
        )
        return orderTranslator.fromDtoListToDomainList(orders)
    }
}