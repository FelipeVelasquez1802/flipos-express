package com.infinitesolutions.domain.entity

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.domain.Constant.Companion.ID
import com.infinitesolutions.domain.Constant.Companion.PASSWORD
import com.infinitesolutions.domain.exception.empty.EmptyPasswordException
import com.infinitesolutions.domain.exception.empty.EmptyUsernameException

data class User constructor(
    @SerializedName(ID) @Expose @Keep val id: Int = -1,
    @SerializedName(USERNAME) @Expose @Keep val username: String,
    @SerializedName(PASSWORD) @Expose @Keep private val password: String? = null,
    private val token: String? = null
) {
    companion object {
        const val USERNAME = "username"
        const val AUTH = "auth"
    }

    @SerializedName(AUTH)
    @Expose
    @Keep
    lateinit var auth: Auth

    var session: Session = Session(id)

    init {
        validateUsername()
        validatePassword()
        if (token != null) session.token = token
    }

    private fun validateUsername() {
        if (username.isEmpty()) throw EmptyUsernameException()
    }

    private fun validatePassword() {
        if (password.isNullOrEmpty()) throw EmptyPasswordException()
        else auth = Auth(userId = id, password = password)
    }

    override fun toString(): String =
        "Username: $username with ID: $id and Token: $session"
}