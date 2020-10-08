package com.infinitesolutions.domain.exception.badid

class BadOrderIdException : RuntimeException(BAD_ORDER_ID_MESSAGE) {
    companion object {
        private const val BAD_ORDER_ID_MESSAGE =
            "Tenemos problemas con esta orden, comunicate con soporte."
    }
}