package com.infinitesolutions.dataaccess.anticorruption

import com.infinitesolutions.dataaccess.dto.UserDto
import com.infinitesolutions.domain.entity.User

class UserTranslator {

    fun fromDomainToDto(user: User): UserDto {
        val userDto = UserDto(user.id, user.username)
        val auth = user.auth
        userDto.password = auth.password
        return userDto
    }

    fun fromDtoToDomain(userDto: UserDto): User {
        return User(userDto.id, userDto.username)
    }

}