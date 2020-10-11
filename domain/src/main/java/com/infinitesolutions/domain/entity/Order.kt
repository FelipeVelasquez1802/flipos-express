package com.infinitesolutions.domain.entity

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.domain.Constant.Companion.ID
import com.infinitesolutions.domain.Constant.Companion.USER
import com.infinitesolutions.domain.exception.BadUserIdException
import com.infinitesolutions.domain.exception.empty.EmptyCostException
import com.infinitesolutions.domain.exception.empty.EmptyDescriptionException
import com.infinitesolutions.domain.exception.empty.EmptyOrderCostException
import com.infinitesolutions.domain.exception.valuenull.DateNullException
import com.infinitesolutions.domain.tool.Format
import com.infinitesolutions.domain.tool.UiDate

data class Order constructor(
    @SerializedName(ID) @Expose @Keep val id: Int = -1,
    @SerializedName(COST) @Expose @Keep var cost: Double,
    @SerializedName(ORDER_COST) @Expose @Keep var orderCost: Double,
    @SerializedName(DESCRIPTION) @Expose @Keep val description: String,
    @SerializedName(USER) @Expose @Keep var userId: Int = -1,
    @SerializedName(FINISH_DATE) @Expose @Keep val finishDate: String? = null,
    @SerializedName(FINISH) @Expose @Keep val finish: Boolean = false,
    @SerializedName(CANCEL) @Expose @Keep val cancel: Boolean = false
) {

    constructor(cost: String, orderCost: String, description: String, userId: Int) : this(
        cost = Companion.validateCost(cost),
        orderCost = validateOrderCost(orderCost),
        description = description,
        userId = userId
    )

    companion object {
        private const val COST = "cost"
        private const val ORDER_COST = "cost_order"
        private const val DESCRIPTION = "description"
        private const val FINISH_DATE = "finish_date"
        private const val FINISH = "finish"
        private const val CANCEL = "cancel"

        private fun validateCost(cost: String): Double {
            if (cost.isEmpty()) throw EmptyCostException()
            return cost.toDouble()
        }

        private fun validateOrderCost(orderCost: String): Double {
            if (orderCost.isEmpty()) throw EmptyOrderCostException()
            return orderCost.toDouble()
        }
    }

    init {
        validateCost()
        validateOrderCost()
        validateDescription()
        validateUserId()
    }

    fun costFormat(): String = Format.formatPrice(cost)

    fun orderCostFormat(): String = Format.formatPrice(orderCost)

    fun finishDateFormat(): String =
        UiDate.fromDateFormatToDateFormat(finishDate ?: throw DateNullException())

    fun totalPriceFormat(): String = Format.formatPrice(orderCost + cost)

    private fun validateCost() {
        if (cost == 0.0) throw EmptyCostException()
    }

    private fun validateOrderCost() {
        if (orderCost == 0.0) throw EmptyOrderCostException()
    }

    private fun validateDescription() {
        if (description.isEmpty()) throw EmptyDescriptionException()
    }

    private fun validateUserId() {
        if (userId < 1) throw BadUserIdException()
    }

}