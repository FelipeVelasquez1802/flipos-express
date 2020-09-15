package com.infinitesolutions.domain.exception

class EmptyValueException : RuntimeException(EMPTY_VALUE_MESSAGE) {
    companion object {
        const val EMPTY_VALUE_MESSAGE = "Este campo no puede ser vacio. Intenta nuevamente."
    }
}