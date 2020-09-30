package com.infinitesolutions.domain.service

import android.util.Log
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.exception.EmptyUserException
import com.infinitesolutions.domain.exception.empty.EmptyTokenException
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
        val token = userRepositoryRemote.login(username, password)
        val user = token?.user ?: throw EmptyUserException()
        return Token(userRepositoryLocal.update(user))
    }

    fun isLogin(): Token? {
        val token = userRepositoryLocal.selectToken()
        if (token.isNullOrEmpty()) {
            val exception = EmptyTokenException()
            Log.d("tag_message", "$CLASS_NAME: ${exception.message}")
            throw exception
        }
        val user = userRepositoryRemote.isLogin(token)?.user ?: throw EmptyUserException()
        return Token(userRepositoryLocal.update(user))
    }
}