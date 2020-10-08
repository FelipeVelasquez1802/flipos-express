package com.infinitesolutions.dataaccess.repository.user.local

import com.infinitesolutions.dataaccess.anticorruption.local.UserTranslator
import com.infinitesolutions.dataaccess.dto.local.UserDto
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.repository.local.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {

    private val userTranslator = UserTranslator()

    override fun insert(user: User): User {
        val userDto = userTranslator.fromDomainToDto(user)
        return select(userDto.id)
    }

    override fun select(id: Int): User {
        val userDto = UserDto(id, "admin", "123qweasdzxc")
        return userTranslator.fromDtoToDomain(userDto)
    }

    override fun selectId(): Int? = 1

    override fun selectToken(): String? = "123qweasdzxc"

    override fun update(user: User): User {
        val userDto = userTranslator.fromDomainToDto(user)
        return select(userDto.id)
    }
}