package com.infinitesolutions.domain.exception.empty

class EmptyCostException : RuntimeException(EMPTY_COST_MESSAGE) {
    companion object {
        private const val EMPTY_COST_MESSAGE = "El campo de costo no puede ser vació."
    }
}