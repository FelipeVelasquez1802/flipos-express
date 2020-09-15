package com.infinitesolutions.fliposexpress.domain.entities

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.domain.Constants
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.EMAIL
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.KEY
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.PASSWORD

class UserDomain(
    @SerializedName(EMAIL)
    @Expose @Keep val email: String?,
    @SerializedName(PASSWORD)
    @Expose @Keep val password: String? = null,
    @SerializedName(KEY)
    @Expose @Keep var key: String? = null
) {
    @SerializedName(Constants.ID)
    @Expose
    @Keep
    var id: Int? = null
}