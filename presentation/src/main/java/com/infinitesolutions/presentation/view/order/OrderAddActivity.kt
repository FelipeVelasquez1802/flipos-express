package com.infinitesolutions.presentation.view.order

import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.tool.goTo
import com.infinitesolutions.presentation.view.base.BaseActivity
import com.infinitesolutions.presentation.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderAddActivity : BaseActivity(), View.OnClickListener {

    private val orderViewModel: OrderViewModel by lazy { ViewModelProvider(this).get(OrderViewModel::class.java) }

    private lateinit var cost: EditText
    private lateinit var orderCost: EditText
    private lateinit var description: EditText

    override fun layout(): Int = R.layout.activity_add_order

    override fun initialElement() {
        cost = findViewById(R.id.etCost)
        orderCost = findViewById(R.id.etOrderCost)
        description = findViewById(R.id.etDescription)
        orderViewModel.ordersActiveLiveData.observe(this, insert())
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btAdd -> buildConsume()
        }
    }

    private fun buildConsume() {
        showLoading()
        val cost = this.cost.text.toString()
        val orderCost = this.orderCost.text.toString()
        val description = this.description.text.toString()
        orderViewModel.executeInsert(cost, orderCost, description)
    }

    private fun insert(): Observer<Resource<List<Order>>> = Observer {
        if (it.isSuccessful) {
            dismissLoading()
            this.goTo(OrderActivity::class.java)
        } else {
            val error = it.error()
            errorDriver(error)
        }
    }
}