package com.infinitesolutions.domain.exception

import java.lang.RuntimeException

class EmptyTokenException:RuntimeException(EMPTY_TOKEN_MESSAGE) {
    companion object{
        const val EMPTY_TOKEN_MESSAGE = "El token llegó nulo."
    }
}