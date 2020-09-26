package com.infinitesolutions.presentation.view.complement

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import com.infinitesolutions.presentation.R

class LoadingDialog(context: Context) : AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.complement_loading)
        this.setCancelable(false)
    }
}