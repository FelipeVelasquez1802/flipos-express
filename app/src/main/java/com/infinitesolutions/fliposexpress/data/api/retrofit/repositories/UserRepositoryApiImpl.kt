package com.infinitesolutions.fliposexpress.data.api.retrofit.repositories

import com.infinitesolutions.fliposexpress.data.api.retrofit.RetrofitConf
import com.infinitesolutions.fliposexpress.data.api.retrofit.dao.UserDao
import com.infinitesolutions.fliposexpress.data.entities.UserEntity
import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.UserRepository
import com.infinitesolutions.fliposexpress.domain.tools.ObjectMapper
import io.reactivex.Observable

class UserRepositoryApiImpl : UserRepository {

    private val userDao: UserDao = RetrofitConf.user()

    override fun login(email: String?, password: String?): Observable<Any?> {
        val user = UserEntity(username = email, password = password)
        return ObjectMapper.toObservableAny(userDao.login(user))
    }

    override fun logout(token: String): Observable<Any?> {
        val authorization = "Token $token"
        return ObjectMapper.toObservableAny(userDao.logout(authorization))
    }

    override fun insert(user: UserDomain): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun select(): Observable<ArrayList<UserDomain>> {
        TODO("Not yet implemented")
    }

    override fun select(id: String): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun selectByUsername(username: String): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun selectFirst(): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun update(user: UserDomain): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }
}