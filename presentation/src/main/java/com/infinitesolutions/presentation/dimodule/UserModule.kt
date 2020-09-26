package com.infinitesolutions.presentation.dimodule

import com.infinitesolutions.dataaccess.repository.user.UserRepositoryImpl
import com.infinitesolutions.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
}