package com.infinitesolutions.domain.exception

import java.lang.RuntimeException

class TranslatorErrorException:RuntimeException(TRANSLATOR_ERROR_MESSAGE) {
    companion object{
        private const val TRANSLATOR_ERROR_MESSAGE = "Tenemos problemas internos, intenta nuevamente. Si el error continua comunicate con soporte."
    }
}