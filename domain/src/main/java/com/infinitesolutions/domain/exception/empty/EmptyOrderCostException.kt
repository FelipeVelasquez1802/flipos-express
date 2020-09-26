package com.infinitesolutions.domain.exception.empty

class EmptyOrderCostException : RuntimeException(EMPTY_ORDER_COST_MESSAGE) {
    companion object {
        private const val EMPTY_ORDER_COST_MESSAGE =
            "El campo de costo del pedido no puede ser vació."
    }
}