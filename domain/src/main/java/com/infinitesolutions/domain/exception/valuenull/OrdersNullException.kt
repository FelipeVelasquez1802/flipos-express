package com.infinitesolutions.domain.exception.valuenull

import java.lang.RuntimeException

class OrdersNullException:RuntimeException(ORDERS_NULL_MESSAGE) {
    companion object{
        private const val ORDERS_NULL_MESSAGE = "Tenemos problemas con la información de tus ordenes, intenta nuevamente o comunicate con soporte."
    }
}