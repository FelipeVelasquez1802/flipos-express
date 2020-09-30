package com.infinitesolutions.dataaccess.repository.user.local

import android.content.Context
import com.infinitesolutions.dataaccess.anticorruption.local.UserTranslator
import com.infinitesolutions.dataaccess.base.LocalRoomDatabase
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.exception.EmptyUserException
import com.infinitesolutions.domain.repository.local.UserRepository
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    @ActivityContext val context: Context
) : UserRepository {

    private val userService: UserService = LocalRoomDatabase.getDatabase(context).userDao()

    private val userTranslator = UserTranslator()

    override fun insert(user: User): User {
        val userDto = userTranslator.fromDomainToDto(user)
        val id = userService.insert(userDto).toInt()
        return select(id)
    }

    override fun select(id: Int): User {
        val user = userService.select(id) ?: throw EmptyUserException()
        return userTranslator.fromDtoToDomain(user)
    }

    override fun selectToken(): String? = userService.selectToken()

    override fun update(user: User): User {
        val userDto = userTranslator.fromDomainToDto(user)
        val result = userService.update(userDto)
        return if (result == 0) insert(user) else select(userDto.id)
    }
}