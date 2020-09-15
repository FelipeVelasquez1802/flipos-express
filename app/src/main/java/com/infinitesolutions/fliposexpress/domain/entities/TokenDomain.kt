package com.infinitesolutions.fliposexpress.domain.entities

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.KEY
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.USER

data class TokenDomain(
    @SerializedName(KEY) @Keep val key: String,
    @SerializedName(USER) @Keep val user: UserDomain
)