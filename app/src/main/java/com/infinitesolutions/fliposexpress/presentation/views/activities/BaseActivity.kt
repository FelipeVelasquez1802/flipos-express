package com.infinitesolutions.fliposexpress.presentation.views.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.infinitesolutions.fliposexpress.R

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var loading: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        createLoading()
    }

    abstract fun layout(): Int

    private fun createLoading() {
        val builder = AlertDialog.Builder(this)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_loading, null)
        loading = builder.setView(view).create()
    }

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}