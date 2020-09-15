package com.infinitesolutions.domain.exception.empty

class EmptyUsernameException : RuntimeException(EMPTY_USERNAME_MESSAGE) {
    companion object {
        private const val EMPTY_USERNAME_MESSAGE =
            "El campo de nombre de usuario no puede estar vacio."
    }
}