package com.infinitesolutions.domain.entity

import javax.security.auth.login.LoginException

class Resource<out T> private constructor(
    private val data: T?,
    private val error: Throwable?
) {
    val isSuccessful: Boolean
        get() = data != null && error == null

    constructor(data: T?) : this(data, null)
    constructor(e: Throwable) : this(null, e)

    fun data(): T = if (data == null || error != null) throw LoginException() else data

    fun error(): Throwable = if (error == null || data != null) throw LoginException() else error
}