package com.infinitesolutions.fliposexpress.domain.services

import com.infinitesolutions.fliposexpress.data.api.retrofit.repositories.OrderRepositoryApiImpl
import com.infinitesolutions.fliposexpress.data.local.room.repositories.OrderRepositoryLocalImpl
import com.infinitesolutions.fliposexpress.data.local.room.repositories.UserRepositoryLocalImpl
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Main
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.OrderRepository
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.UserRepository
import com.infinitesolutions.fliposexpress.domain.tools.Logs
import com.infinitesolutions.fliposexpress.domain.tools.ObjectMapper
import io.reactivex.Observable

class MainService(private val presenter: Main.Presenter) : Main.Service {

    private val userRepository: UserRepository = UserRepositoryLocalImpl()
    private val orderRepository: OrderRepository = OrderRepositoryLocalImpl()
    private val orderRepositoryApi: OrderRepository = OrderRepositoryApiImpl()

    override fun saveOrder(order: OrderDomain) {
        val userDisposable = userRepository.selectFirst()
            .flatMap {
                val userId = it.id
                if (userId == null) Observable.just(null)
                else {
                    order.userId = userId
                    orderRepositoryApi.insertAndShowAll(order)
                }
            }
        select(userDisposable)
    }

    override fun update(order: OrderDomain) {
        TODO("Not yet implemented")
    }

    override fun selectOrders() {
        val userDisposable = userRepository.selectFirst()
            .flatMap {
                val userId = it.id
                if (userId == null) Observable.just(null)
                else {
                    orderRepositoryApi.selectByUser(userId)
                }
            }
        select(userDisposable)
    }

    private fun select(observable: Observable<List<OrderDomain>?>) {
        val orderDisposable = observable.subscribe({
            Logs.showMessage(ObjectMapper.serializer(it ?: "This is null"))
            presenter.setOrders(it as ArrayList<OrderDomain>)
        }, this::failed)
    }

    private fun failed(t: Throwable) {
        Logs.showError(t.message)
    }
}