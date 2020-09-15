package com.infinitesolutions.presentation.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infinitesolutions.presentation.Constant.Companion.MESSAGE
import com.infinitesolutions.presentation.view.complement.ErrorDialog

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        private const val TAG_BASE_ACTIVITY = "TAG_BASE_ACTIVITY"
    }

    private val errorDialog by lazy { ErrorDialog() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        initialElement()
    }

    abstract fun layout(): Int

    abstract fun initialElement()

    protected fun showError(message: String) {
        val args = Bundle()
        args.putString(MESSAGE, message)
        errorDialog.let {
            it.arguments = args
            it.show(supportFragmentManager, TAG_BASE_ACTIVITY)
        }
    }
}