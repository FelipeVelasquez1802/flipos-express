package com.infinitesolutions.presentation.view.complement

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import com.infinitesolutions.presentation.Constant.Companion.DEFAULT_MESSAGE
import com.infinitesolutions.presentation.Constant.Companion.MESSAGE
import com.infinitesolutions.presentation.R

class ErrorDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val message = arguments?.getString(MESSAGE, DEFAULT_MESSAGE)
            builder.setTitle(R.string.error)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null)
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}