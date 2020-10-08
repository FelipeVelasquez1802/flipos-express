package com.infinitesolutions.presentation.view.order

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.view.base.BaseListActivity
import com.infinitesolutions.presentation.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderHistoryActivity : BaseListActivity() {

    private val orderViewModel: OrderViewModel by lazy { ViewModelProvider(this).get(OrderViewModel::class.java) }
    private val orders: ArrayList<Order> = ArrayList()

    private lateinit var listEmpty: View
    private lateinit var list: RecyclerView
    private lateinit var adapter: OrderHistoryAdapter

    override fun layout(): Int = R.layout.activity_history_order

    override fun initialElement() {
        showLoading()
        initialList()
        orderViewModel.let {
            it.ordersLiveData.observe(this, selectByUser())
            it.executeSelectInactiveByUser()
        }
    }

    private fun initialList() {
        listEmpty = findViewById(R.id.listEmpty)
        adapter = OrderHistoryAdapter(this, orders)
        list = findViewById(R.id.rvList)
        list.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
    }

    private fun selectByUser(): Observer<Resource<List<Order>>> = Observer {
        if (it.isSuccessful) {
            val orders = it.data()
            showAndHide(orders.isEmpty(), list, listEmpty)
            adapter.addAll(orders)
            dismissLoading()
        } else {
            val error = it.error()
            errorDriver(error)
        }
    }
}