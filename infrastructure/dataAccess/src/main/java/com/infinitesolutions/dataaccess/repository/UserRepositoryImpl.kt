package com.infinitesolutions.dataaccess.repository

import com.infinitesolutions.dataaccess.Constant.Companion.HOSTNAME
import com.infinitesolutions.dataaccess.anticorruption.TokenTranslator
import com.infinitesolutions.dataaccess.dto.TokenDto
import com.infinitesolutions.dataaccess.dto.UserDto
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.exception.EmptyUserException
import com.infinitesolutions.domain.exception.UserLoginException
import com.infinitesolutions.domain.repository.UserRepository
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {


    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(HOSTNAME)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val tokenTranslator: TokenTranslator by lazy { TokenTranslator() }

    override fun login(username: String, password: String): Token? {
        val auth = UserDto(username = username, password = password)
        val userService = retrofit.create(UserService::class.java)
        val call = userService.login(auth)
        return try {
            val response: Response<TokenDto> = call.execute()
            val tokenDto = response.body()!!
            tokenTranslator.fromDtoToDomain(tokenDto)
        } catch (exception: EmptyUserException) {
            throw UserLoginException()
        }
    }

    override fun logout(token: String): Any? {
        TODO("Not yet implemented")
    }
}