package com.infinitesolutions.fliposexpress.data

class Constants {
    companion object {
        // Hostname

        const val HOSTNAME = "http://192.168.0.14:8000/"
        private const val API_V = "api/v1/"

        // User

        private const val AUTH_API = "api-auth/"
        const val LOGIN = "${AUTH_API}login"
        const val LOGOUT = "${AUTH_API}logout"

        // Order

        const val ORDERS = "${API_V}orders/"
        const val BY_USER = "${ORDERS}by_user/{user_id}"


        // Database

        const val NAME_DATABASE = "flipos_express"

        // Tables

        const val TABLE_USER = "user"
        const val TABLE_ORDER = "order"

        // Columns

        const val KEY = "key"
        const val ID = "id"
        const val EMAIL = "email"
        const val USERNAME = "username"
        const val PASSWORD = "password"
        const val COST = "cost"
        const val ORDER_COST = "cost_order"
        const val DESCRIPTION = "description"
        const val USER_ID = "user_id"
        const val CREATION_DATE = "creation_date"
        const val FINISH = "finish"
    }
}