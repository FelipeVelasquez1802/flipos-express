package com.infinitesolutions.dataaccess.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.dataaccess.Constant.Companion.ID

data class OrderDto(
    @SerializedName(ID) @Expose @Keep val id: Int,
    @SerializedName(COST) @Expose @Keep val cost: Double,
    @SerializedName(ORDER_COST) @Expose @Keep val orderCost: Double,
    @SerializedName(DESCRIPTION) @Expose @Keep val description: String
) {
    companion object {
        private const val COST = "cost"
        private const val ORDER_COST = "cost_order"
        private const val DESCRIPTION = "description"
    }
}