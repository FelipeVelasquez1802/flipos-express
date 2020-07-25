package com.infinitesolutions.fliposexpress.domain.tools

import android.util.Log
import com.infinitesolutions.fliposexpress.domain.Constants
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.ERROR

class Logs {
    companion object {

        fun showMessage(message: String?) {
            Log.d(Constants.TAG, message ?: "This is null")
        }

        fun showError(error: String?) {
            Log.d(Constants.TAG, error ?: ERROR)
        }
    }
}