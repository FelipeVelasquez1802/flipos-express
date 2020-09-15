package com.infinitesolutions.fliposexpress.data.local.room.repositories

import com.infinitesolutions.fliposexpress.data.local.room.LocalRoomDatabase
import com.infinitesolutions.fliposexpress.data.local.room.dao.UserDao
import com.infinitesolutions.fliposexpress.domain.entities.TokenDomain
import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.UserRepository
import com.infinitesolutions.fliposexpress.domain.tools.ObjectMapper
import com.infinitesolutions.fliposexpress.presentation.views.activities.BaseApplication
import io.reactivex.Observable

class UserRepositoryLocalImpl : UserRepository {

    private val userDao: UserDao =
        LocalRoomDatabase.getDatabase(BaseApplication.getContext()).userDao()

    override fun login(email: String?, password: String?): Observable<TokenDomain> {
        TODO("Not yet implemented")
    }

    override fun logout(token: String): Observable<Any?> {
        TODO("Not yet implemented")
    }


    override fun insert(user: UserDomain): Observable<UserDomain?> {
        val userEntity = ObjectMapper.toUserEntity(user)
        val userId = userEntity.id!!
        return ObjectMapper.toObservableInt(userDao.insert(userEntity))
            .flatMap {
                if (it == -1) Observable.just(null)
                else select(userId)
            }
    }

    override fun select(): Observable<ArrayList<UserDomain>> {
        val users = userDao.select()
        return ObjectMapper.toObservableUsersDomain(users)
    }

    override fun selectByUsername(username: String): Observable<UserDomain?> {
        val user = userDao.selectByUsername(username)
        return ObjectMapper.toObservableUserDomain(user)
    }

    override fun select(id: Int): Observable<UserDomain?> {
        val user = userDao.select(id)
        return ObjectMapper.toObservableUserDomain(user)
    }

    override fun selectFirst(): Observable<UserDomain?> {
        val user = userDao.selectFirst()
        return ObjectMapper.toObservableUserDomain(user)
    }

    override fun update(user: UserDomain): Observable<UserDomain?> {
        val userEntity = ObjectMapper.toUserEntity(user)
        val id = userEntity.id!!
        return ObjectMapper.toObservableBoolean(userDao.update(userEntity))
            .flatMap { if (it) select(id) else insert(user) }
    }
}