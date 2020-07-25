package com.infinitesolutions.fliposexpress.domain.interfaces.repositories

import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import io.reactivex.Observable

interface UserRepository {
    fun login(email: String?, password: String?): Observable<Any?>
    fun insert(user: UserDomain): Observable<UserDomain?>
    fun select(): Observable<ArrayList<UserDomain>>
    fun select(id: String): Observable<UserDomain?>
    fun selectByUsername(username: String): Observable<UserDomain?>
    fun selectFirst(): Observable<UserDomain?>
    fun update(user: UserDomain): Observable<UserDomain?>
}