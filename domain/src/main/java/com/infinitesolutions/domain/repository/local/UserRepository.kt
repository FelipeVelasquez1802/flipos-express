package com.infinitesolutions.domain.repository.local

import com.infinitesolutions.domain.entity.User

interface UserRepository {
    fun insert(user: User): User
    fun select(id: Int): User
    fun selectToken(): String?
    fun update(user: User): User
}