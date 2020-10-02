package com.infinitesolutions.domain.entity

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.domain.Constant
import com.infinitesolutions.domain.exception.empty.EmptyCostException
import com.infinitesolutions.domain.exception.empty.EmptyDescriptionException
import com.infinitesolutions.domain.exception.empty.EmptyOrderCostException
import com.infinitesolutions.domain.tool.Format

data class Order(
    @SerializedName(Constant.ID) @Expose @Keep val id: Int = -1,
    @SerializedName(COST) @Expose @Keep val cost: Double,
    @SerializedName(ORDER_COST) @Expose @Keep val orderCost: Double,
    @SerializedName(DESCRIPTION) @Expose @Keep val description: String? = null
) {
    companion object {
        private const val COST = "cost"
        private const val ORDER_COST = "cost_order"
        private const val DESCRIPTION = "description"
    }

    init {
        validateCost()
        validateOrderCost()
        validateDescription()
    }

    fun costFormat(): String = Format.formatPrice(cost)

    fun orderCostFormat(): String = Format.formatPrice(orderCost)

    private fun validateCost() {
        if (cost == 0.0) throw EmptyCostException()
    }

    private fun validateOrderCost() {
        if (orderCost == 0.0) throw EmptyOrderCostException()
    }

    private fun validateDescription() {
        if (description.isNullOrEmpty()) throw EmptyDescriptionException()
    }
}