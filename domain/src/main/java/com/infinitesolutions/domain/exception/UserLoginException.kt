package com.infinitesolutions.domain.exception

class UserLoginException() : RuntimeException(USER_LOGIN_FAILED_MESSAGE) {

    companion object {
        const val USER_LOGIN_FAILED_MESSAGE = "Correo o contraseña incorrecta."
    }

}