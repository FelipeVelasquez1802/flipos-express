package com.infinitesolutions.fliposexpress.domain.tools

import java.text.NumberFormat
import java.util.*

class Formats {
    companion object {
        fun formatPrice(price: Double): String =
            NumberFormat.getCurrencyInstance(Locale.US).format(price)
    }
}