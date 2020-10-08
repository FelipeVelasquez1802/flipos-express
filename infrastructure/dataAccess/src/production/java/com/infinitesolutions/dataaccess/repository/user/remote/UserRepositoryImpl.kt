package com.infinitesolutions.dataaccess.repository.user.remote

import com.infinitesolutions.dataaccess.anticorruption.TokenTranslator
import com.infinitesolutions.dataaccess.base.RemoteRetrofit
import com.infinitesolutions.dataaccess.dto.TokenDto
import com.infinitesolutions.dataaccess.dto.remote.UserDto
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.repository.remote.UserRepository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {

    companion object {
        private const val AUTHORIZATION = "Token {}"
    }

    private var userService = RemoteRetrofit.retrofit.create(UserService::class.java)

    private val tokenTranslator: TokenTranslator by lazy { TokenTranslator() }

    override fun login(username: String, password: String): Token? {
        val auth = UserDto(username = username, password = password)
        val call = userService.login(auth)
        return buildResponse(call)
    }

    private fun buildResponse(call: Call<TokenDto>): Token? {
        val response: Response<TokenDto> = call.execute()
        val tokenDto = response.body()
        return tokenTranslator.fromDtoToDomain(tokenDto)
    }

    override fun logout(token: String): Any? {
        TODO("Not yet implemented")
    }

    override fun isLogin(token: String): Token? {
        val authorization = AUTHORIZATION.replace("{}", token)
        val call = userService.isLogin(authorization)
        return buildResponse(call)
    }
}