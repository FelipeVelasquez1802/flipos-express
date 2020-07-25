package com.infinitesolutions.fliposexpress.presentation.views.activities

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.infinitesolutions.fliposexpress.R
import com.infinitesolutions.fliposexpress.domain.interfaces.Splash
import com.infinitesolutions.fliposexpress.presentation.presenters.SplashPresenter
import com.infinitesolutions.fliposexpress.presentation.tools.IntentAdministrator

class SplashActivity : AppCompatActivity(), Splash.View {

    private val presenter: Splash.Presenter = SplashPresenter(this)

    companion object {
        const val SLEEP = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.initial()
    }

    override fun waitAndGo() {
        Handler().postDelayed({
            presenter.isLogin()
        }, SLEEP)
    }

    override fun goLogin() {
        IntentAdministrator.goLogin()
    }

    override fun goMain() {
        IntentAdministrator.goMain()
    }
}
