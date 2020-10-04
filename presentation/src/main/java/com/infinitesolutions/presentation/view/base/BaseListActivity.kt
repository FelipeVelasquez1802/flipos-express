package com.infinitesolutions.presentation.view.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListActivity : BaseActivity() {
    protected fun showAndHide(isEmpty: Boolean, list: RecyclerView, listEmpty: View) {
        if (isEmpty) {
            listEmpty.visibility = View.VISIBLE
            list.visibility = View.GONE
        } else {
            listEmpty.visibility = View.GONE
            list.visibility = View.VISIBLE
        }
    }
}