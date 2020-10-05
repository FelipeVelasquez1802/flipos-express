package com.infinitesolutions.presentation.tool

import android.content.Context

class UiString(private val context: Context) {

    fun replaceValue(message: Int, value: String): String? =
        context.getString(message).replace("{}", value)
}