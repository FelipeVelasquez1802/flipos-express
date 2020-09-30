package com.infinitesolutions.domain.entity

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.domain.Constant.Companion.KEY
import com.infinitesolutions.domain.Constant.Companion.USER

data class Token constructor(
    @SerializedName(KEY) @Expose @Keep val key: String,
    @SerializedName(USER) @Expose @Keep val user: User
) {
    constructor(user: User) : this(user.getTokenNotNull(), user)

    init {
        user.session.token = key
    }

    override fun toString(): String {
        return "Token: $key, User: $user.}"
    }
}