package com.infinitesolutions.domain.exception

import java.lang.RuntimeException

class FailedUpdateException:RuntimeException(FAILED_UPDATE_MESSAGE) {
    companion object{
        private const val FAILED_UPDATE_MESSAGE = "Tenemos problemas con tus credenciales, intenta iniciar sesión nuevamente."
    }
}