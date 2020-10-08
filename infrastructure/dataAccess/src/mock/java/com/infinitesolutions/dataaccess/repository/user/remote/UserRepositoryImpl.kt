package com.infinitesolutions.dataaccess.repository.user.remote

import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.repository.remote.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {
    override fun login(username: String, password: String): Token? {
        val key = "123qweasdzxc"
        return Token(key, User(1, username, password, key))
    }

    override fun logout(token: String): Any? {
        TODO("Not yet implemented")
    }

    override fun isLogin(token: String): Token? {
        val key = "123qweasdzxc"
        return Token(key, User(1, "admin", "admin1234", key))
    }
}