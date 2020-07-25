package com.infinitesolutions.fliposexpress.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.fliposexpress.R
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain

class OrderAdapter(private val orders: ArrayList<OrderDomain>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cost: TextView = itemView.findViewById(R.id.tvCost)
        val orderCost: TextView = itemView.findViewById(R.id.tvOrderCost)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_order, parent, false
        )
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.cost.text = "${order.cost}"
        holder.orderCost.text = "${order.orderCost}"
        holder.description.text = order.description
    }
}