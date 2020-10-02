package com.infinitesolutions.presentation.view.order

import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.view.base.BaseActivity

class HistoryOrderActivity : BaseActivity() {

    private lateinit var orders: RecyclerView

    override fun layout(): Int = R.layout.activity_history_order

    override fun initialElement() {
        orders = findViewById(R.id.rvList)
    }
}