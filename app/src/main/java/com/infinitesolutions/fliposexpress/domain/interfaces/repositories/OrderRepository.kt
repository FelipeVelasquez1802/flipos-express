package com.infinitesolutions.fliposexpress.domain.interfaces.repositories

import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import io.reactivex.Observable

interface OrderRepository {
    fun insert(order: OrderDomain): Observable<OrderDomain?>
    fun select(): Observable<List<OrderDomain>>
    fun select(id: Int): Observable<OrderDomain?>
    fun selectByUser(userId: String): Observable<List<OrderDomain>>
    fun selectFirst(): Observable<OrderDomain?>
    fun update(order: OrderDomain): Observable<OrderDomain?>
}