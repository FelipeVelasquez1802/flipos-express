package com.infinitesolutions.fliposexpress.domain.interfaces

interface Splash {

    interface View {
        fun waitAndGo()
        fun goLogin()
        fun goMain()
    }

    interface Presenter {
        fun initial()
        fun isLogin()
        fun goLogin()
        fun goMain()
    }

    interface Service {
        fun isLogin()
    }
}