package com.infinitesolutions.fliposexpress.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.fliposexpress.R
import com.infinitesolutions.fliposexpress.domain.entities.OrderDomain

class OrderActiveAdapter(private val orders: List<OrderDomain>) :
    RecyclerView.Adapter<OrderActiveAdapter.OrderActiveViewHolder>() {
    class OrderActiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderActiveViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_order_active, parent, false)
        return OrderActiveViewHolder(view)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderActiveViewHolder, position: Int) {

    }
}