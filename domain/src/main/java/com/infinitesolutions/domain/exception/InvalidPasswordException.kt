package com.infinitesolutions.domain.exception

class InvalidPasswordException : RuntimeException(INVALID_PASSWORD) {
    companion object {
        const val INVALID_PASSWORD = "Esta contraseña es invalida..."
    }
}