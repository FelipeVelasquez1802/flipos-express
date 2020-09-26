package com.infinitesolutions.presentation.tool

import android.app.Activity
import android.content.Intent

fun <T> Activity.goTo(clazz: Class<T>) = Intent(this, clazz)
    .apply { this.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK }
    .let { this.startActivity(it) }