package com.infinitesolutions.domain.exception

import java.lang.RuntimeException

class EmptyUserException :RuntimeException(){
    companion object{
        const val EMPTY_USER_MESSAGE = "El usuario llegó nulo"
    }
}