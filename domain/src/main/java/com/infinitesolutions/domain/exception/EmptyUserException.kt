package com.infinitesolutions.domain.exception

class EmptyUserException : RuntimeException() {
    companion object {
        const val EMPTY_USER_MESSAGE = "Tenemos problemas con el usuario, llegó nulo"
    }
}