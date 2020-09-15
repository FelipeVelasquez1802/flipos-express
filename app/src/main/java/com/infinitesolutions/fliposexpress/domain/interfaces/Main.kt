package com.infinitesolutions.fliposexpress.domain.interfaces

import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain

interface Main {
    interface View {
        fun initialObjects()
        fun initialElements()
        fun initialLayout()
        fun addAdapters()
        fun setOrders(orders: ArrayList<OrderDomain>)
        fun errorCost(value: String? = null)
        fun errorOrderCost(value: String? = null)
        fun errorDescription(value: String? = null)
        fun deleteFields()
    }

    interface Presenter {
        fun initial()
        fun setOrders(orders: ArrayList<OrderDomain>)
        fun saveOrder(cost: String, orderCost: String, description: String)
        fun updateOrder(cost: String, orderCost: String, description: String)
    }

    interface Service {
        fun saveOrder(order: OrderDomain)
        fun update(order: OrderDomain)
        fun selectOrders()
    }
}