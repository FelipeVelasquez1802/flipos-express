package com.infinitesolutions.fliposexpress.presentation.tools

import android.content.Intent
import com.infinitesolutions.fliposexpress.presentation.views.activities.BaseApplication
import com.infinitesolutions.fliposexpress.presentation.views.activities.LoginActivity
import com.infinitesolutions.fliposexpress.presentation.views.activities.MainActivity

class IntentAdministrator {
    companion object {
        private fun createIntent(cls: Class<*>) {
            val intent = Intent(BaseApplication.getContext(), cls)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            BaseApplication.getContext().startActivity(intent)
        }

        fun goMain() {
            val cls = MainActivity::class.java
            createIntent(cls)
        }

        fun goLogin() {
            val cls = LoginActivity::class.java
            createIntent(cls)
        }
    }
}