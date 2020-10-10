package com.infinitesolutions.presentation.view.complement

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.infinitesolutions.presentation.R

class ConfirmDialog constructor(private val action: () -> Unit) : DialogFragment() {

    constructor() : this({})

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = activity?.let {
        val builder = AlertDialog.Builder(it)
        builder.setTitle(R.string.title_confirm_dialog)
            .setMessage(R.string.message_confirm_dialog)
            .setPositiveButton(R.string.yes) { _, _ -> action() }
            .setNegativeButton(R.string.no, null)
            .create()
    } ?: throw IllegalStateException("Activity cannot be null")


}