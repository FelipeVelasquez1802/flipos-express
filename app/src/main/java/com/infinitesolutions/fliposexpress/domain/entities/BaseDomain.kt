package com.infinitesolutions.fliposexpress.domain.entities

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.domain.Constants.Companion.ID
import java.io.Serializable

open class BaseDomain(
    @SerializedName(ID)
    @Expose @Keep val id: Int?
) : Serializable