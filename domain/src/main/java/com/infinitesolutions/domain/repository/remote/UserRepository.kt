package com.infinitesolutions.domain.repository.remote

import com.infinitesolutions.domain.entity.Token

interface UserRepository {
    fun login(username: String, password: String): Token?
    fun logout(token: String): Any?
    fun isLogin(token: String): Token?
}