package com.infinitesolutions.presentation.view.order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.tool.UiString

class OrderAdapter constructor(
    private val context: Context,
    private val orders: ArrayList<Order>,
    private val listener: ActionListener
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private val uiString: UiString by lazy { UiString(context) }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cost: TextView = itemView.findViewById(R.id.tvCost)
        val orderCost: TextView = itemView.findViewById(R.id.tvOrderCost)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val finish: Button = itemView.findViewById(R.id.btFinish)
        val moreOption: ImageView = itemView.findViewById(R.id.ivMoreOption)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_order, parent, false)
            .let { OrderViewHolder(it) }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.cost.text = uiString.replaceValue(R.string.cost_message, order.costFormat())
        holder.orderCost.text =
            uiString.replaceValue(R.string.order_cost_message, order.orderCostFormat())
        holder.description.text = order.description
        holder.finish.setOnClickListener { listener.finishOrder(order.id) }
        holder.moreOption.setOnClickListener { showPopup(it, order.id) }
    }

    override fun getItemCount(): Int = orders.size

    fun addAll(orders: List<Order>) {
        this.orders.let {
            it.clear()
            it.addAll(orders)
        }
        this.notifyDataSetChanged()
    }

    private fun showPopup(view: View, orderId: Int) {
        val popup = PopupMenu(context, view)
        popup.let {
            it.menuInflater.inflate(R.menu.menu_action_item_order, popup.menu)
            it.setOnMenuItemClickListener { menuItem -> typeOption(menuItem.itemId, orderId) }
            it.show()
        }
    }

    private fun typeOption(itemId: Int, orderId: Int): Boolean {
        return when (itemId) {
            R.id.itCancel -> {
                listener.cancelOrder(orderId)
                true
            }
            R.id.itEdit -> {
                Toast.makeText(context, "Edit order", Toast.LENGTH_LONG).show()
                true
            }
            else -> false
        }
    }

    interface ActionListener {
        fun finishOrder(orderId: Int)
        fun cancelOrder(orderId: Int)
    }
}