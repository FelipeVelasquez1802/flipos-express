package com.infinitesolutions.domain.exception.valuenull

import java.lang.RuntimeException

class IdNullException:RuntimeException(ID_NULL_MESSAGE) {
    companion object{
        private const val ID_NULL_MESSAGE = "Este ID viene nulo intenta nuevamente."
    }
}