package com.infinitesolutions.fliposexpress.presentation.presenters

import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Login
import com.infinitesolutions.fliposexpress.domain.services.LoginService

class LoginPresenter(private val view: Login.View) : Login.Presenter {

    private val service: Login.Service = LoginService(this)
    override fun initial() {
        view.initialObjects()
        view.initialElements()
    }

    override fun login(email: String, password: String) {
        val user = UserDomain(email = email, password = password)
        view.showLoading()
        service.login(user)
    }

    override fun goMain() {
        view.hideLoading()
        view.goMain()
    }

    override fun showMessage(message: String) {
        view.hideLoading()
        view.showMessage(message)
    }

}