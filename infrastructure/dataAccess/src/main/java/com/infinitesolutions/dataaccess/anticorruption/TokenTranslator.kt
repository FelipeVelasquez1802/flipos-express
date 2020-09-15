package com.infinitesolutions.dataaccess.anticorruption

import com.infinitesolutions.dataaccess.dto.TokenDto
import com.infinitesolutions.domain.entity.Token

class TokenTranslator {

    private val userTranslator by lazy { UserTranslator() }

    fun fromDtoToDomain(tokenDto: TokenDto): Token {
        val user = tokenDto.user
        return Token(tokenDto.key, userTranslator.fromDtoToDomain(user))
    }
}