package com.infinitesolutions.fliposexpress.presentation.views.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.infinitesolutions.fliposexpress.R
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.ADD
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.ORDER
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.TYPE
import com.infinitesolutions.fliposexpress.presentation.Constants.Companion.UPDATE

class OrderFormDialog(private val listener: OrderFormInterface) : DialogFragment(),
    OrderFormInterface.Dialog,
    View.OnClickListener {

    private lateinit var cost: EditText
    private lateinit var orderCost: EditText
    private lateinit var description: EditText
    private lateinit var save: Button
    private lateinit var update: Button

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val view = requireActivity().layoutInflater.inflate(
                R.layout.dialog_fort_edit_order, null
            )
            cost = view.findViewById(R.id.etCost)
            orderCost = view.findViewById(R.id.etOrderCost)
            description = view.findViewById(R.id.etDescription)
            save = view.findViewById(R.id.btSave)
            update = view.findViewById(R.id.btUpdate)
            val type = arguments?.getString(TYPE)
            if (!type.isNullOrEmpty() && type == UPDATE) {
                val order = arguments!!.getSerializable(ORDER) as OrderDomain
                initialData(order)
                configPanel(type)
            }
            initialListener()
            val dialog = builder.setView(view).create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun initialData(order: OrderDomain) {
        cost.setText(order.getCostString())
        orderCost.setText(order.getOrderCostString())
        description.setText(order.description)
    }

    private fun initialListener() {
        save.setOnClickListener(this)
        update.setOnClickListener(this)
    }

    private fun configPanel(type: String?) {
        if (type == UPDATE) {
            save.visibility = View.GONE
            update.visibility = View.VISIBLE
        } else {
            save.visibility = View.VISIBLE
            update.visibility = View.GONE
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btSave -> {
                val cost = this.cost.text.toString()
                val orderCost = this.orderCost.text.toString()
                val description = this.description.text.toString()
                listener.insertOrder(cost, orderCost, description)
            }
            R.id.btUpdate -> {
                val cost = this.cost.text.toString()
                val orderCost = this.orderCost.text.toString()
                val description = this.description.text.toString()
                listener.updateOrder(cost, orderCost, description)
            }
        }
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
}