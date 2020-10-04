package com.infinitesolutions.domain.tool

import com.infinitesolutions.domain.exception.valuenull.DateNullException
import java.text.SimpleDateFormat
import java.util.*

class UiDate {
    companion object {

        private const val FORMAT_GENERIC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        private const val FORMAT_SIMPLE = "dd 'de' MMM 'del' YYYY"

        private const val TYPE_LOCALE_LANGUAGE = "es"
        private const val TYPE_LOCALE_COUNTRY = "ES"

        fun fromStringToDate(date: String): Date {
            val format = SimpleDateFormat(
                FORMAT_GENERIC, Locale(TYPE_LOCALE_LANGUAGE, TYPE_LOCALE_COUNTRY)
            )
            return format.parse(date) ?: throw DateNullException()
        }

        fun fromDateFormatToDateFormat(date: String): String {
            val format = SimpleDateFormat(
                FORMAT_SIMPLE, Locale(TYPE_LOCALE_LANGUAGE, TYPE_LOCALE_COUNTRY)
            )
            val otherFormat = fromStringToDate(date)
            return format.format(otherFormat)
        }
    }
}