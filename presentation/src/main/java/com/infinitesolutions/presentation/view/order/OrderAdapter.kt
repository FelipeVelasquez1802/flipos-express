package com.infinitesolutions.presentation.view.order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.presentation.R

class OrderAdapter private constructor(
    private val context: Context? = null,
    private val orders: ArrayList<Order>,
    private val onListener: OnListener? = null
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    constructor(orders: ArrayList<Order>) : this(null, orders, null)
    constructor(context: Context, orders: ArrayList<Order>) : this(context, orders, null)

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cost: TextView = itemView.findViewById(R.id.tvCost)
        val orderCost: TextView = itemView.findViewById(R.id.tvOrderCost)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_order, parent, false)
            .let { OrderViewHolder(it) }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.cost.text = replaceValue(R.string.cost_message, order.costFormat())
        holder.orderCost.text = replaceValue(R.string.order_cost_message, order.orderCostFormat())
        holder.description.text = order.description
    }

    private fun replaceValue(message: Int, value: String): String? =
        context?.getString(message)?.replace("{}", value)

    override fun getItemCount(): Int = orders.size

    fun addAll(orders: List<Order>) {
        this.orders.let {
            it.clear()
            it.addAll(orders)
        }
        this.notifyDataSetChanged()
    }

    interface OnListener {
        fun onItemClick(order: Order)
    }
}