package com.infinitesolutions.dataaccess.dto

import androidx.annotation.Keep
import com.infinitesolutions.dataaccess.Constant.Companion.ID
import com.infinitesolutions.dataaccess.Constant.Companion.PASSWORD
import com.infinitesolutions.dataaccess.Constant.Companion.USERNAME
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName(ID) @Expose @Keep val id: Int = -1,
    @SerializedName(USERNAME) @Expose @Keep val username: String,
    @SerializedName(PASSWORD) @Expose @Keep var password: String? = null
)