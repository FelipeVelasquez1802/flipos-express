package com.infinitesolutions.domain.exception.empty

class EmptyPasswordException : RuntimeException(EMPTY_PASSWORD_MESSAGE) {
    companion object {
        private const val EMPTY_PASSWORD_MESSAGE = "El campo de contraseña no puede ser vació."
    }
}