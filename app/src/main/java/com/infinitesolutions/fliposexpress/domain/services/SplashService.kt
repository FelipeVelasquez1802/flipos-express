package com.infinitesolutions.fliposexpress.domain.services

import com.infinitesolutions.fliposexpress.data.local.room.repositories.UserRepositoryLocalImpl
import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Splash
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.UserRepository
import com.infinitesolutions.fliposexpress.domain.tools.Logs

class SplashService(private val presenter: Splash.Presenter) : Splash.Service {


    private val userRepository: UserRepository = UserRepositoryLocalImpl()
    override fun isLogin() {
        val userDisposable = userRepository.selectFirst()
            .subscribe(this::loginSuccess, this::onFailed)
    }

    private fun loginSuccess(user: UserDomain?) {
        if (user != null) {
            presenter.goMain()
        } else {
            Logs.showError("Error")
            presenter.goLogin()
        }
    }

    private fun onFailed(t: Throwable) {
        Logs.showError(t.message)
        presenter.goLogin()
    }
}