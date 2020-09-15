package com.infinitesolutions.domain.service

import android.util.Log
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.exception.UserLoginException
import com.infinitesolutions.domain.repository.UserRepository
import javax.inject.Inject

class UserService @Inject constructor(private val userRepository: UserRepository) {

    fun login(username: String, password: String): Token {
        val token = userRepository.login(username, password)
        return token ?: throw UserLoginException()
    }
}