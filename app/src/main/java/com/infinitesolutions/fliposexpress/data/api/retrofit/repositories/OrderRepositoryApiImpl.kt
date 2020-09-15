package com.infinitesolutions.fliposexpress.data.api.retrofit.repositories

import com.infinitesolutions.fliposexpress.data.api.retrofit.RetrofitConf
import com.infinitesolutions.fliposexpress.data.api.retrofit.dao.OrderDao
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.OrderRepository
import com.infinitesolutions.fliposexpress.domain.tools.ObjectMapper
import io.reactivex.Observable

class OrderRepositoryApiImpl : OrderRepository {

    private val orderDao: OrderDao = RetrofitConf.order()

    override fun insert(order: OrderDomain): Observable<OrderDomain?> {
        TODO("Not yet implemented")
    }

    override fun insertAndShowAll(order: OrderDomain): Observable<List<OrderDomain>> {
        val orderEntity = ObjectMapper.toOrderEntity(order)
        return ObjectMapper.toObservableOrders(orderDao.insertOrder(orderEntity))
    }

    override fun select(): Observable<List<OrderDomain>> {
        TODO("Not yet implemented")
    }

    override fun select(id: Int): Observable<OrderDomain?> {
        TODO("Not yet implemented")
    }

    override fun selectByUser(userId: Int): Observable<List<OrderDomain>> {
        val orders = orderDao.orderByUser(userId)
        return ObjectMapper.toObservableOrders(orders)
    }

    override fun selectFirst(): Observable<OrderDomain?> {
        TODO("Not yet implemented")
    }

    override fun update(order: OrderDomain): Observable<OrderDomain?> {
        TODO("Not yet implemented")
    }
}