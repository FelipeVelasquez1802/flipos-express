package com.infinitesolutions.presentation.view.order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.presentation.R

class OrderTypeAdapter(private val context: Context, private val orders: ArrayList<Order>) :
    RecyclerView.Adapter<OrderTypeAdapter.OrderViewHolder>() {

    companion object {
        private const val ORDER_FINISH = "Domicilios finalizadas"
        private const val ORDER_CANCEL = "Domicilios cancelados"
        private val TYPE: List<String> = listOf(ORDER_FINISH, ORDER_CANCEL)
    }

    private lateinit var adapter: OrderHistoryAdapter

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val list: RecyclerView = itemView.findViewById(R.id.rvList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_order_type, parent, false)
            .let { OrderViewHolder(it) }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val type = TYPE[position]
        holder.title.text = type
        initialListOrders(holder.list, type)
    }

    private fun initialListOrders(list: RecyclerView, type: String) {
        val orders = filterOrders(type)
        list.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = OrderHistoryAdapter(context, orders)
        }
    }

    private fun filterOrders(type: String): ArrayList<Order> =
        when (type) {
            ORDER_FINISH -> orders.filter { it.finish && !it.cancel }
            ORDER_CANCEL -> orders.filter { it.cancel && !it.finish }
            else -> listOf()
        } as ArrayList<Order>

    override fun getItemCount(): Int = TYPE.size
}