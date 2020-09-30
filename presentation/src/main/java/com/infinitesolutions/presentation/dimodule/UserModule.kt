package com.infinitesolutions.presentation.dimodule

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import com.infinitesolutions.dataaccess.repository.user.local.UserRepositoryImpl as UserRepositoryImplLocal
import com.infinitesolutions.dataaccess.repository.user.remote.UserRepositoryImpl as UserRepositoryImplRemote
import com.infinitesolutions.domain.repository.local.UserRepository as UserRepositoryLocal
import com.infinitesolutions.domain.repository.remote.UserRepository as UserRepositoryRemote

@Module
@InstallIn(ActivityComponent::class)
abstract class LoginModule {
    @Binds
    abstract fun bindUserRepositoryRemote(userRepository: UserRepositoryImplRemote): UserRepositoryRemote

    @Binds
    abstract fun bindUserRepositoryLocal(userRepository: UserRepositoryImplLocal): UserRepositoryLocal
}