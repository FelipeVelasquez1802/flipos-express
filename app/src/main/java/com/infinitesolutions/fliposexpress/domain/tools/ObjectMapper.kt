package com.infinitesolutions.fliposexpress.domain.tools

import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.infinitesolutions.fliposexpress.data.entities.OrderEntity
import com.infinitesolutions.fliposexpress.data.entities.TokenEntity
import com.infinitesolutions.fliposexpress.data.entities.UserEntity
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.entities.TokenDomain
import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ObjectMapper {
    companion object {
        private val gson: Gson = Gson()
        fun serializer(any: Any): String = gson.toJson(any)

        // toDomain

        fun toTokenDomain(token: TokenEntity): TokenDomain =
            gson.fromJson(serializer(token), TokenDomain::class.java)

        fun toUserDomain(user: UserEntity?): UserDomain? =
            if (user == null) null
            else gson.fromJson(serializer(user), UserDomain::class.java)

        fun toUserDomain(user: FirebaseUser?): UserDomain? =
            if (user == null) null
            else gson.fromJson(serializer(user), UserDomain::class.java)

        fun toUsersDomain(users: ArrayList<UserEntity>): ArrayList<UserDomain> {
            val type = object : TypeToken<ArrayList<UserDomain>>() {}.type
            return gson.fromJson(serializer(users), type)
        }

        fun toOrdersDomain(orders: List<OrderEntity>): List<OrderDomain> {
            val type = object : TypeToken<ArrayList<OrderDomain>>() {}.type
            return gson.fromJson(serializer(orders), type)
        }

        fun toOrderDomain(order: OrderEntity?): OrderDomain? =
            if (order == null) null
            else gson.fromJson(serializer(order), OrderDomain::class.java)

        fun toObservableInt(long: Single<Long>): Observable<Int> =
            long.flatMapObservable { Observable.just(it.toInt()) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        fun toObservableUserDomain(single: Single<UserEntity?>): Observable<UserDomain?> =
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapObservable { Observable.just(toUserDomain(it)) }

        fun toObservableUsersDomain(single: Single<List<UserEntity>>): Observable<ArrayList<UserDomain>> =
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapObservable { Observable.just(toUsersDomain(it as ArrayList<UserEntity>)) }

        fun toObservableBoolean(single: Single<Int>): Observable<Boolean> =
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapObservable { Observable.just(it != 0) }

        fun toObservableOrder(single: Single<OrderEntity?>): Observable<OrderDomain?> =
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapObservable { Observable.just(toOrderDomain(it)) }

        fun toObservableAny(single: Single<Any?>): Observable<Any?> =
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapObservable { Observable.just(it) }


        // Data

        fun toObservableTokenEntity(single: Single<TokenEntity>): Observable<TokenDomain> =
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { toTokenDomain(it) }
                .flatMapObservable { Observable.just(it) }

        fun toObservableOrders(single: Single<List<OrderEntity>>): Observable<List<OrderDomain>> =
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { toOrdersDomain(it) }
                .flatMapObservable { Observable.just(it) }

        fun toUserEntity(user: UserDomain): UserEntity =
            gson.fromJson(serializer(user), UserEntity::class.java)

        fun toOrderEntity(order: OrderDomain): OrderEntity =
            gson.fromJson(serializer(order), OrderEntity::class.java)
    }
}