package com.infinitesolutions.fliposexpress.data.local.room.repositories

import com.infinitesolutions.fliposexpress.data.local.room.LocalRoomDatabase
import com.infinitesolutions.fliposexpress.data.local.room.dao.OrderDao
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.OrderRepository
import com.infinitesolutions.fliposexpress.domain.tools.ObjectMapper
import com.infinitesolutions.fliposexpress.presentation.views.activities.BaseApplication
import io.reactivex.Observable

class OrderRepositoryLocalImpl : OrderRepository {

    private val orderDao: OrderDao =
        LocalRoomDatabase.getDatabase(BaseApplication.getContext()).orderDao()

    override fun insert(order: OrderDomain): Observable<OrderDomain?> {
        val orderEntity = ObjectMapper.toOrderEntity(order)
        return ObjectMapper.toObservableInt(orderDao.insert(orderEntity))
            .flatMap { select(it) }
    }

    override fun select(): Observable<List<OrderDomain>> {
        val orders = orderDao.select()
        return ObjectMapper.toObservableOrders(orders)
    }

    override fun select(id: Int): Observable<OrderDomain?> {
        val order = orderDao.select(id)
        return ObjectMapper.toObservableOrder(order)
    }

    override fun selectByUser(userId: String): Observable<List<OrderDomain>> {
        val order = orderDao.selectByUser(userId)
        return ObjectMapper.toObservableOrders(order)
    }

    override fun selectFirst(): Observable<OrderDomain?> {
        val order = orderDao.selectFirst()
        return ObjectMapper.toObservableOrder(order)
    }

    override fun update(order: OrderDomain): Observable<OrderDomain?> {
        val orderEntity = ObjectMapper.toOrderEntity(order)
        return ObjectMapper.toObservableBoolean(orderDao.update(orderEntity))
            .flatMap {
                if (it) {
                    val id = orderEntity.id
                    select(id)
                } else insert(order)
            }
    }
}