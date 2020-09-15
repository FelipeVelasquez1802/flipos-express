package com.infinitesolutions.fliposexpress.presentation.views.activities

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.fliposexpress.R
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.Main
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.ADD
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.ORDER
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.TYPE
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.UPDATE
import com.infinitesolutions.fliposexpress.presentation.presenters.MainPresenter
import com.infinitesolutions.fliposexpress.presentation.views.adapters.OrderActiveAdapter
import com.infinitesolutions.fliposexpress.presentation.views.adapters.OrderAdapter
import com.infinitesolutions.fliposexpress.presentation.views.dialog.OrderFormDialog
import com.infinitesolutions.fliposexpress.presentation.views.dialog.OrderFormInterface

class MainActivity : AppCompatActivity(), Main.View, View.OnClickListener,
    OrderAdapter.OnClickItem, OrderFormInterface {

    private val presenter: Main.Presenter by lazy { MainPresenter(this) }

    private lateinit var ordersRecyclerView: RecyclerView
    private lateinit var ordersActiveRecyclerView: RecyclerView
    private lateinit var dialogEditOrder: OrderFormDialog

    private lateinit var adapter: OrderAdapter
    private lateinit var adapterActive: OrderActiveAdapter
    private var ordersInactive: ArrayList<OrderDomain> = ArrayList()
    private var ordersActive: ArrayList<OrderDomain> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.initial()
    }

    override fun initialObjects() {
        adapter = OrderAdapter(ordersInactive, this)
        adapterActive = OrderActiveAdapter(ordersActive)
    }

    override fun initialElements() {
        dialogEditOrder = OrderFormDialog(this)
        dialogEditOrder.isCancelable = false
    }

    override fun initialLayout() {
        //ordersRecyclerView.layoutManager = LinearLayoutManager(this)
        //ordersActiveRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun addAdapters() {
        val decoration = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        ordersRecyclerView.addItemDecoration(decoration)
        ordersRecyclerView.adapter = adapter
        ordersActiveRecyclerView.addItemDecoration(decoration)
        ordersActiveRecyclerView.adapter = adapterActive
    }

    override fun setOrders(orders: ArrayList<OrderDomain>) {

        dialogEditOrder.dismiss()
    }

    override fun errorCost(value: String?) {
        dialogEditOrder.errorCost(value)
    }

    override fun errorOrderCost(value: String?) {
        dialogEditOrder.errorOrderCost(value)
    }

    override fun errorDescription(value: String?) {
        dialogEditOrder.errorDescription(value)
    }

    override fun deleteFields() {
        dialogEditOrder.deleteFields()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btAdd -> {
                val args = Bundle()
                args.putString(TYPE, ADD)
                dialogEditOrder.arguments = args
                dialogEditOrder.show(supportFragmentManager, "DIALOG_ADD_ORDER")
            }
            R.id.btCancel -> {
                dialogEditOrder.deleteFields()
                dialogEditOrder.dismiss()
            }
        }
    }

    override fun onClick(order: OrderDomain, view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_actions, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it?.itemId) {
                R.id.itemEdit -> {
                    val args = Bundle()
                    args.putSerializable(ORDER, order)
                    args.putString(TYPE, UPDATE)
                    dialogEditOrder.arguments = args
                    dialogEditOrder.show(supportFragmentManager, "DIALOG_EDIT_ORDER")
                }
            }
            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }

    override fun insertOrder(cost: String, orderCost: String, description: String) {
        presenter.saveOrder(cost, orderCost, description)
    }

    override fun updateOrder(cost: String, orderCost: String, description: String) {
        presenter.updateOrder(cost, orderCost, description)
    }
}
