package com.infinitesolutions.domain.entity

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.domain.Constant.Companion.USER_ID
import com.infinitesolutions.domain.exception.InvalidPasswordException
import com.infinitesolutions.domain.exception.empty.EmptyPasswordException
import java.util.regex.Pattern

class Auth(
    @SerializedName(USER_ID) @Expose @Keep val userId: Int,
    @SerializedName(PASSWORD) @Expose @Keep var password: String?
) {
    companion object {
        const val AUTH = "AUTH"
        const val PASSWORD_PATTERN = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,}$"
        const val PASSWORD = "password"
    }

    init {
        val password = this.password
        if (password.isNullOrEmpty()) {
            throw EmptyPasswordException()
        } else if (isPasswordValid(password)) {
            throw InvalidPasswordException()
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        val pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }
}