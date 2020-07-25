package com.infinitesolutions.fliposexpress.data.api.firebase.repositories

import com.infinitesolutions.fliposexpress.data.api.firebase.ApiFirebase
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.OrderRepository
import com.infinitesolutions.fliposexpress.domain.tools.Logs
import com.infinitesolutions.fliposexpress.domain.tools.ObjectMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Observable

class OrderRepositoryApiImpl : OrderRepository {

    private val apiFirebase = ApiFirebase.reference()

    override fun insert(order: OrderDomain): Observable<OrderDomain?> {
        TODO("Not yet implemented")
    }

    override fun select(): Observable<List<OrderDomain>> {
        TODO("Not yet implemented")
    }

    override fun select(id: Int): Observable<OrderDomain?> {
        TODO("Not yet implemented")
    }

    override fun selectByUser(userId: String): Observable<List<OrderDomain>> {
        TODO("Not yet implemented")
    }

    override fun selectFirst(): Observable<OrderDomain?> {
        TODO("Not yet implemented")
    }

    override fun update(order: OrderDomain): Observable<OrderDomain?> {
        return RxFirebaseDatabase.observeSingleValueEvent(
            apiFirebase.child("head"), OrderDomain::class.java
        ).flatMapObservable {
            Logs.showMessage(ObjectMapper.serializer(it))
            Observable.just(it)
        }
    }
}