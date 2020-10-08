package com.infinitesolutions.domain.service

import android.util.Log
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.exception.EmptyUserException
import com.infinitesolutions.domain.exception.empty.EmptyPasswordException
import com.infinitesolutions.domain.exception.empty.EmptyTokenException
import com.infinitesolutions.domain.exception.empty.EmptyUsernameException
import com.infinitesolutions.domain.exception.valuenull.IdNullException
import javax.inject.Inject
import com.infinitesolutions.domain.repository.local.UserRepository as UserRepositoryLocal
import com.infinitesolutions.domain.repository.remote.UserRepository as UserRepositoryRemote

class UserService @Inject constructor(
    private val userRepositoryLocal: UserRepositoryLocal,
    private val userRepositoryRemote: UserRepositoryRemote
) {

    companion object {
        private const val CLASS_NAME = "USER_SERVICE"
    }

    fun login(username: String, password: String): Token? {
        if (username.isEmpty()) throw EmptyUsernameException()
        if (password.isEmpty()) throw EmptyPasswordException()
        val token = userRepositoryRemote.login(username, password)
        val user = token?.user ?: throw EmptyUserException()
        return Token(userRepositoryLocal.update(user))
    }

    fun isLogin(): Token {
        val key = userRepositoryLocal.selectToken()
        if (key.isNullOrEmpty()) {
            val exception = EmptyTokenException()
            Log.d("tag_message", "$CLASS_NAME: ${exception.message}")
            throw exception
        }
        val token = userRepositoryRemote.isLogin(key) ?: throw EmptyUserException()
        val user = token.user
        return Token(userRepositoryLocal.update(user))
    }

    fun selectId(): Int {
        val id = userRepositoryLocal.selectId()
        if (id == null) {
            val exception = IdNullException()
            Log.d("tag_message", "$CLASS_NAME: ${exception.message}")
            throw exception
        }
        return id
    }
}