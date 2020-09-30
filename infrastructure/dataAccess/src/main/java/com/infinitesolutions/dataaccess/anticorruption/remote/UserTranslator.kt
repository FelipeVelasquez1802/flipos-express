package com.infinitesolutions.dataaccess.anticorruption.remote

import com.infinitesolutions.dataaccess.dto.remote.UserDto
import com.infinitesolutions.domain.entity.User

class UserTranslator {

    fun fromDtoToDomain(userDto: UserDto): User {
        return User(userDto.id, userDto.username)
    }

}