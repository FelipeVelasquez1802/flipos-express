package com.infinitesolutions.dataaccess.anticorruption.local

import com.infinitesolutions.dataaccess.dto.local.UserDto
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.exception.empty.EmptyTokenException

class UserTranslator {

    fun fromDomainToDto(user: User): UserDto {
        val token = user.session.token ?: throw EmptyTokenException()
        return UserDto(user.id, user.username, token)
    }

    fun fromDtoToDomain(user: UserDto): User = User(user.id, user.username, token = user.token)
}