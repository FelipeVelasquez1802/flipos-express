package com.infinitesolutions.domain.tool

import java.text.DecimalFormat

class Format {
    companion object {
        private val FORMAT_PRICE = DecimalFormat("$ #,###")

        fun formatPrice(price: Double): String = FORMAT_PRICE.format(price)
    }
}