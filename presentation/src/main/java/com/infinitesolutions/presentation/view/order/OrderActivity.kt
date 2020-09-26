package com.infinitesolutions.presentation.view.order

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.view.base.BaseActivity
import com.infinitesolutions.presentation.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderActivity : BaseActivity() {

    private val orderViewModel: OrderViewModel by lazy { ViewModelProvider(this).get(OrderViewModel::class.java) }
    private val orders: ArrayList<Order> = ArrayList()

    private lateinit var listEmpty: View
    private lateinit var list: RecyclerView
    private lateinit var adapter: OrderAdapter

    override fun layout(): Int = R.layout.activity_order

    override fun initialElement() {
        showLoading()
        initialList()
        orderViewModel.let {
            it.getSelectByUserLiveData().observe(this, selectByUser())
            it.executeSelectByUser()
        }
    }

    private fun initialList() {
        listEmpty = findViewById(R.id.listEmpty)
        adapter = OrderAdapter(this, orders)
        list = findViewById(R.id.rvList)
        list.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
    }

    private fun selectByUser(): Observer<Resource<List<Order>>> = Observer {
        if (it.isSuccessful) {
            val orders = it.data()
            showAndHide(orders.isEmpty())
            adapter.addAll(orders)
            dismissLoading()
        } else {
            val error = it.error()
            errorDriver(error)
        }
    }

    private fun showAndHide(isEmpty: Boolean) {
        if (isEmpty) {
            listEmpty.visibility = View.VISIBLE
            list.visibility = View.GONE
        } else {
            listEmpty.visibility = View.GONE
            list.visibility = View.VISIBLE
        }
    }

}
