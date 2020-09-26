package com.infinitesolutions.domain.service

import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.repository.UserRepository
import javax.inject.Inject

class UserService @Inject constructor(private val userRepository: UserRepository) {

    fun login(username: String, password: String): Token? = userRepository.login(username, password)
}