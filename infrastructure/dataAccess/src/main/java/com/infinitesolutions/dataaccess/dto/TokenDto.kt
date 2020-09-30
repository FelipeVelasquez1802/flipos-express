package com.infinitesolutions.dataaccess.dto

import androidx.annotation.Keep
import com.infinitesolutions.dataaccess.Constant.Companion.KEY
import com.infinitesolutions.dataaccess.Constant.Companion.USER
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.dataaccess.dto.remote.UserDto

data class TokenDto(
    @SerializedName(KEY) @Expose @Keep val key: String,
    @SerializedName(USER) @Expose @Keep val user: UserDto
)