package com.infinitesolutions.presentation.view.order

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.tool.goTo
import com.infinitesolutions.presentation.view.base.BaseListActivity
import com.infinitesolutions.presentation.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderActivity : BaseListActivity(), View.OnClickListener, OrderAdapter.ActionListener {

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
            it.ordersLiveData.observe(this, selectByUser())
            it.executeSelectActiveByUser()
        }
    }

    private fun initialList() {
        listEmpty = findViewById(R.id.listEmpty)
        adapter = OrderAdapter(this, orders, this)
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

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btAdd -> this.goTo(OrderAddActivity::class.java, false)
            R.id.tvShowHistory -> this.goTo(OrderHistoryActivity::class.java, false)
        }
    }

    override fun finishOrder(orderId: Int) {
        orderViewModel.executeUpdateFinish(orderId)
    }

}
