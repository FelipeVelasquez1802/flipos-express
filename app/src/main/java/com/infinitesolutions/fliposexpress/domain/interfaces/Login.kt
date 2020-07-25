package com.infinitesolutions.fliposexpress.domain.interfaces

import com.infinitesolutions.fliposexpress.domain.entities.UserDomain

interface Login {
    interface View {
        fun initialObjects()
        fun initialElements()
        fun goMain()

        fun showLoading()
        fun hideLoading()
        fun showMessage(message: String)
    }

    interface Presenter {
        fun initial()
        fun login(email: String, password: String)
        fun goMain()
        fun showMessage(message: String)
    }

    interface Service {
        fun login(user: UserDomain)
    }
}