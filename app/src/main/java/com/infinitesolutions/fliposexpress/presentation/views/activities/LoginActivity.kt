package com.infinitesolutions.fliposexpress.presentation.views.activities

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.infinitesolutions.fliposexpress.R
import com.infinitesolutions.fliposexpress.domain.interfaces.Login
import com.infinitesolutions.fliposexpress.presentation.presenters.LoginPresenter
import com.infinitesolutions.fliposexpress.presentation.tools.IntentAdministrator

class LoginActivity : BaseActivity(), Login.View, View.OnClickListener {

    private val presenter: Login.Presenter =
        LoginPresenter(this)

    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initial()
    }

    override fun layout(): Int = R.layout.activity_login

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btLogin -> {
                presenter.login(username.text.toString(), password.text.toString())
            }
        }
    }

    override fun initialObjects() {

    }

    override fun initialElements() {
        username = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
    }

    override fun goMain() {
        IntentAdministrator.goMain()
    }

    override fun showLoading() {
        loading.show()
    }

    override fun hideLoading() {
        loading.dismiss()
    }

    override fun showMessage(message: String) {
        showToast(message)
    }
}
