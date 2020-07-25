package com.infinitesolutions.fliposexpress.domain.entities

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.domain.Constants

class OrderDomain(
    id: Int? = null,
    @SerializedName(Constants.COST)
    @Expose @Keep val cost: Double,
    @SerializedName(Constants.ORDER_COST)
    @Expose @Keep val orderCost: Double,
    @SerializedName(Constants.DESCRIPTION)
    @Expose @Keep val description: String? = null
) : BaseDomain(id) {
    @SerializedName(Constants.USER_ID)
    @Expose
    @Keep
    var userId: String? = null

    @SerializedName(Constants.DATE)
    @Expose
    @Keep
    var date: String? = null

}