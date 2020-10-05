package com.infinitesolutions.domain.exception.valuenull

class DateNullException : RuntimeException(DATE_NULL_MESSAGE) {
    companion object {
        private const val DATE_NULL_MESSAGE =
            "Lo sentimos, estamos presentando problemas con la fecha."
    }
}