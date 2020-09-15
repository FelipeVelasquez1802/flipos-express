package com.infinitesolutions.fliposexpress.domain.entities

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.domain.Constants
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.FINISH
import com.infinitesolutions.fliposexpress.domain.tools.Formats

class OrderDomain(
    id: Int? = null,
    @SerializedName(Constants.COST)
    @Expose @Keep val cost: Double,
    @SerializedName(Constants.ORDER_COST)
    @Expose @Keep val orderCost: Double,
    @SerializedName(Constants.DESCRIPTION)
    @Expose @Keep val description: String? = null,
    @SerializedName(FINISH)
    @Expose @Keep val finish: Boolean = false
) : BaseDomain(id) {
    @SerializedName(Constants.USER)
    @Expose
    @Keep
    var userId: Int? = null

    @SerializedName(Constants.DATE)
    @Expose
    @Keep
    var date: String? = null

    fun getCostString(): String = "$cost"

    fun getCostPrice(): String = Formats.formatPrice(cost)

    fun getOrderCostString(): String = "$orderCost"

    fun getOrderCostPrice(): String = Formats.formatPrice(orderCost)

}