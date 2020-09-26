package com.infinitesolutions.presentation.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infinitesolutions.presentation.Constant
import com.infinitesolutions.presentation.Constant.Companion.MESSAGE
import com.infinitesolutions.presentation.view.complement.ErrorDialog
import com.infinitesolutions.presentation.view.complement.LoadingDialog

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        private const val TAG_BASE_ACTIVITY = "TAG_BASE_ACTIVITY"
    }

    private val errorDialog by lazy { ErrorDialog() }
    private val loadingDialog by lazy { LoadingDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        initialElement()
    }

    abstract fun layout(): Int

    abstract fun initialElement()

    protected fun errorDriver(e: Throwable) {
        dismissLoading()
        showError(e.message ?: Constant.DEFAULT_MESSAGE)
    }

    private fun showError(message: String) {
        errorDialog.let {
            val args = Bundle()
            args.putString(MESSAGE, message)
            it.arguments = args
            it.show(supportFragmentManager, TAG_BASE_ACTIVITY)
        }
    }

    protected fun showLoading() {
        loadingDialog.show()
    }

    protected fun dismissLoading() {
        loadingDialog.dismiss()
    }
}