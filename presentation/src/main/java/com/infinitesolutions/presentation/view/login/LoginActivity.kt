package com.infinitesolutions.presentation.view.login

import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.tool.goTo
import com.infinitesolutions.presentation.view.base.BaseActivity
import com.infinitesolutions.presentation.view.order.OrderActivity
import com.infinitesolutions.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var userViewModel: UserViewModel

    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun layout(): Int = R.layout.activity_login

    override fun initialElement() {
        username = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getLoginLiveData().observe(this, login())
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btLogin -> validateLogin()
        }
    }

    private fun validateLogin() {
        showLoading()
        try {
            val username = this.username.text.toString()
            val password = this.password.text.toString()
            val user = User(username = username, password = password)
            userViewModel.executeLogin(user)
        } catch (e: Throwable) {
            errorDriver(e)
        }
    }

    private fun login(): Observer<Resource<User>> = Observer {
        if (it.isSuccessful) {
            dismissLoading()
            this.goTo(OrderActivity::class.java)
        } else {
            val error = it.error()
            errorDriver(error)
        }
    }
}