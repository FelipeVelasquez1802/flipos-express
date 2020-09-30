package com.infinitesolutions.presentation.view.splash

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.tool.goTo
import com.infinitesolutions.presentation.view.base.BaseActivity
import com.infinitesolutions.presentation.view.login.LoginActivity
import com.infinitesolutions.presentation.view.order.OrderActivity
import com.infinitesolutions.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    companion object {
        const val SLEEP = 1000L
    }

    private val userViewModel: UserViewModel by lazy { ViewModelProvider(this).get(UserViewModel::class.java) }

    override fun layout(): Int = R.layout.activity_splash

    override fun initialElement() {
        userViewModel.isLoginLiveData.observe(this, isLogin())
        android.os.Handler().postDelayed({
            userViewModel.executeIsLogin()
        }, SLEEP)
    }

    private fun isLogin() = Observer<Resource<User>> {
        if (it.isSuccessful) {
            this.goTo(OrderActivity::class.java)
        } else {
            this.goTo(LoginActivity::class.java)
        }
    }
}