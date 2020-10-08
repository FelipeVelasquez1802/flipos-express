package com.infinitesolutions.domain.exception

class BadUserIdException : RuntimeException(BAD_USERID_MESSAGE) {
    companion object {
        private const val BAD_USERID_MESSAGE =
            "Tenemos un problema con tus credenciales, lo sentimos."
    }
}