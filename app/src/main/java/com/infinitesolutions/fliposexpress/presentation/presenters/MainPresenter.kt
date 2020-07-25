package com.infinitesolutions.fliposexpress.presentation.presenters

import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Main
import com.infinitesolutions.fliposexpress.domain.services.MainService

class MainPresenter(private val view: Main.View) : Main.Presenter {
    private val service: Main.Service = MainService(this)

    companion object {
        const val errorField = "Este campo es obligatorio"
    }

    override fun initial() {
        view.initialObjects()
        view.initialElements()
        view.initialLayout()
        view.addAdapters()
        service.selectOrders()
    }

    override fun setOrders(orders: ArrayList<OrderDomain>) {
        view.setOrders(orders)
        view.deleteFields()
    }

    override fun saveOrder(cost: String, orderCost: String, description: String) {
        var count = 0
        if (cost.isEmpty()) view.errorCost(errorField)
        else {
            view.errorCost()
            count++
        }
        if (orderCost.isEmpty()) view.errorOrderCost(errorField)
        else {
            view.errorOrderCost()
            count++
        }
        if (description.isEmpty()) view.errorDescription(errorField)
        else {
            view.errorDescription()
            count++
        }
        if (count == 3) {
            val order = OrderDomain(
                cost = cost.toDouble(),
                orderCost = orderCost.toDouble(),
                description = description
            )
            service.saveOrder(order)
        }
    }
}