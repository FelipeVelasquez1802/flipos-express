package com.infinitesolutions.domain.exception.empty

class EmptyDescriptionException : RuntimeException(EMPTY_DESCRIPTION_MESSAGE) {
    companion object {
        private const val EMPTY_DESCRIPTION_MESSAGE = "El campo descripción no puede ser vació."
    }
}