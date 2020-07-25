package com.infinitesolutions.fliposexpress.presentation.views.activities

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.fliposexpress.R
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Main
import com.infinitesolutions.fliposexpress.presentation.presenters.MainPresenter
import com.infinitesolutions.fliposexpress.presentation.views.adapters.OrderAdapter

class MainActivity : AppCompatActivity(), Main.View, View.OnClickListener {

    private val presenter: Main.Presenter = MainPresenter(this)
    private lateinit var cost: EditText
    private lateinit var orderCost: EditText
    private lateinit var description: EditText
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: OrderAdapter
    private var orders: ArrayList<OrderDomain> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.initial()
    }

    override fun initialObjects() {
        adapter = OrderAdapter(orders)
    }

    override fun initialElements() {
        cost = findViewById(R.id.etCost)
        orderCost = findViewById(R.id.etOrderCost)
        description = findViewById(R.id.etDescription)
        recyclerView = findViewById(R.id.rvList)
    }

    override fun initialLayout() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun addAdapters() {
        recyclerView.adapter = adapter
    }

    override fun setOrders(orders: ArrayList<OrderDomain>) {
        this.orders.clear()
        this.orders.addAll(orders)
        adapter.notifyDataSetChanged()
    }

    override fun errorCost(value: String?) {
        cost.error = value
    }

    override fun errorOrderCost(value: String?) {
        orderCost.error = value
    }

    override fun errorDescription(value: String?) {
        description.error = value
    }

    override fun deleteFields() {
        cost.setText("")
        orderCost.setText("")
        description.setText("")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btSave -> {
                val cost = this.cost.text.toString()
                val orderCost = this.orderCost.text.toString()
                val description = this.description.text.toString()
                presenter.saveOrder(cost, orderCost, description)
            }
        }
    }
}
