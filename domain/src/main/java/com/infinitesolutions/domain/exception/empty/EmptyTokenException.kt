package com.infinitesolutions.domain.exception.empty

class EmptyTokenException : RuntimeException(EMPTY_TOKEN_MESSAGE) {
    companion object {
        private const val EMPTY_TOKEN_MESSAGE =
            "Tenemos un problema con las credenciales del usuario."
    }
}