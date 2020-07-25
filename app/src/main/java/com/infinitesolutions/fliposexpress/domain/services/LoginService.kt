package com.infinitesolutions.fliposexpress.domain.services

import com.infinitesolutions.fliposexpress.data.api.firebase.repositories.UserRepositoryApiImpl
import com.infinitesolutions.fliposexpress.data.local.room.repositories.UserRepositoryLocalImpl
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.ERROR
import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Login
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.UserRepository
import com.infinitesolutions.fliposexpress.domain.tools.Logs
import com.infinitesolutions.fliposexpress.domain.tools.ObjectMapper
import io.reactivex.Observable

class LoginService(private val presenter: Login.Presenter) : Login.Service {

    private val userRepositoryLocal: UserRepository = UserRepositoryLocalImpl()
    private val userRepositoryApi: UserRepository = UserRepositoryApiImpl()


    override fun login(user: UserDomain) {
        val email = user.email
        val password = user.password
        val userDisposable = userRepositoryApi.login(email, password)
            .flatMap {
                if (it is UserDomain) userRepositoryLocal.update(it)
                else Observable.just(null)
            }
            .subscribe(this::loginSuccess, this::onFailed)
    }

    private fun loginSuccess(user: UserDomain?) {
        if (user != null) {
            presenter.goMain()
        } else Logs.showError("Error")
    }

    private fun onFailed(t: Throwable) {
        Logs.showError(t.message)
        presenter.showMessage(t.message ?: ERROR)
    }
}