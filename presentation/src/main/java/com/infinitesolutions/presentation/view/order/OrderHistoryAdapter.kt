package com.infinitesolutions.presentation.view.order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.tool.UiString

class OrderHistoryAdapter constructor(
    private val context: Context,
    private val orders: ArrayList<Order>
) : RecyclerView.Adapter<OrderHistoryAdapter.OrderViewHolder>() {

    private val uiString: UiString by lazy { UiString(context) }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.tvTextOrder)
        val date: TextView = itemView.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item_order_inactive, parent, false)
            .let { OrderViewHolder(it) }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.text.text = uiString.replaceValue(R.string.total_price, order.totalPriceFormat())
        holder.date.text = uiString.replaceValue(R.string.date_order, order.finishDateFormat())
    }

    override fun getItemCount(): Int = orders.size

    fun addAll(orders: List<Order>) {
        this.orders.let {
            it.clear()
            it.addAll(orders)
        }
        this.notifyDataSetChanged()
    }
}