package com.infinitesolutions.dataaccess.anticorruption

import com.infinitesolutions.dataaccess.dto.TokenDto
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.exception.TranslatorErrorException

class TokenTranslator {

    private val userTranslator by lazy { UserTranslator() }

    fun fromDtoToDomain(tokenDto: TokenDto?): Token {
        if (tokenDto==null) throw TranslatorErrorException()
        val user = tokenDto.user
        return Token(tokenDto.key, userTranslator.fromDtoToDomain(user))
    }
}