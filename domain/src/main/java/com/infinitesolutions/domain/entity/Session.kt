package com.infinitesolutions.domain.entity

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.domain.Constant.Companion.KEY
import com.infinitesolutions.domain.Constant.Companion.USER_ID

data class Session(
    @SerializedName(USER_ID) @Expose @Keep private val userId: Int
) {
    @SerializedName(KEY)
    @Expose
    @Keep
    var token: String? = null

    override fun toString(): String {
        return "Token: $token"
    }
}