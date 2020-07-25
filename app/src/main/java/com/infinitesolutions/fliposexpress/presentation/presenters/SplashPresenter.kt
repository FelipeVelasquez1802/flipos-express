package com.infinitesolutions.fliposexpress.presentation.presenters

import com.infinitesolutions.fliposexpress.domain.interfaces.Splash
import com.infinitesolutions.fliposexpress.domain.services.SplashService

class SplashPresenter(private val view: Splash.View) : Splash.Presenter {
    private val service: Splash.Service = SplashService(this)
    override fun initial() {
        view.waitAndGo()
    }

    override fun isLogin() {
        service.isLogin()
    }

    override fun goLogin() {
        view.goLogin()
    }

    override fun goMain() {
        view.goMain()
    }
}