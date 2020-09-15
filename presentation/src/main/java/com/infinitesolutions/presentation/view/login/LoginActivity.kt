package com.infinitesolutions.presentation.view.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.exception.empty.EmptyPasswordException
import com.infinitesolutions.domain.exception.empty.EmptyUsernameException
import com.infinitesolutions.presentation.Constant.Companion.DEFAULT_MESSAGE
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.view.base.BaseActivity
import com.infinitesolutions.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var userViewModel: UserViewModel

    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    override fun layout(): Int = R.layout.activity_login

    override fun initialElement() {
        username = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btLogin -> validateLogin()
        }
    }

    private fun validateLogin() {
        try {
            val username = this.username.text.toString()
            val password = this.password.text.toString()
            val user = User(username = username, password = password)
            userViewModel.executeLogin(user).observe(this, login())
        } catch (e: Throwable) {
            errorDriver(e)
        }
    }

    private fun errorDriver(e: Throwable) {
        showError(e.message ?: DEFAULT_MESSAGE)
    }

    private fun login(): Observer<in User?> = Observer {
        Log.d("tag_message", it.toString())
    }
}