package com.infinitesolutions.presentation.view.order

import android.view.View
import android.widget.EditText
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.view.base.BaseActivity

class OrderAddActivity : BaseActivity(), View.OnClickListener {

    private lateinit var cost: EditText
    private lateinit var orderCost: EditText
    private lateinit var description: EditText

    override fun layout(): Int = R.layout.activity_add_order

    override fun initialElement() {
        cost = findViewById(R.id.etCost)
        orderCost = findViewById(R.id.etOrderCost)
        description = findViewById(R.id.etDescription)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btAdd -> buildConsume()
        }
    }

    private fun buildConsume() {
        showLoading()
        try {
            val cost = this.cost.text.toString()
            val orderCost = this.orderCost.text.toString()
            val description = this.description.text.toString()
            val order = Order(cost, orderCost, description)
        } catch (e: Throwable) {
            errorDriver(e)
        }
    }

}