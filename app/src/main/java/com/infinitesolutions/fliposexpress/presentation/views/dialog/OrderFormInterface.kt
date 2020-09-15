package com.infinitesolutions.fliposexpress.presentation.views.dialog

interface OrderFormInterface {

    fun insertOrder(cost: String, orderCost: String, description: String)
    fun updateOrder(cost: String, orderCost: String, description: String)

    interface Dialog {

        fun errorCost(value: String? = null)
        fun errorOrderCost(value: String? = null)
        fun errorDescription(value: String? = null)
        fun deleteFields()

    }
}