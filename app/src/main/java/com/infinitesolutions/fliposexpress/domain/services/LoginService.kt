package com.infinitesolutions.fliposexpress.domain.services

import com.infinitesolutions.fliposexpress.data.api.retrofit.repositories.UserRepositoryApiImpl
import com.infinitesolutions.fliposexpress.data.local.room.repositories.UserRepositoryLocalImpl
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.ERROR
import com.infinitesolutions.fliposexpress.domain.entities.TokenDomain
import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Login
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.UserRepository
import com.infinitesolutions.fliposexpress.domain.tools.Logs

class LoginService(private val presenter: Login.Presenter) : Login.Service {

    private val userRepositoryLocal: UserRepository = UserRepositoryLocalImpl()
    private val userRepositoryApi: UserRepository = UserRepositoryApiImpl()


    override fun login(user: UserDomain) {
        val email = user.email
        val password = user.password
        val disposable = userRepositoryApi.login(email, password)
            .flatMap {
                val key = it.key
                val userDomain = it.user
                userDomain.key = key
                userRepositoryLocal.update(userDomain)
            }
            .subscribe(this::loginSuccess, this::onFailed)
    }

    private fun loginSuccess(token: TokenDomain) {
        presenter.goMain()
    }

    private fun loginSuccess(user: UserDomain?) {
        if (user != null) presenter.goMain()
        else Logs.showError("Error")
    }

    private fun onFailed(t: Throwable) {
        Logs.showError(t.message)
        presenter.showMessage(t.message ?: ERROR)
    }
}