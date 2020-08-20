package com.infinitesolutions.fliposexpress.data

class Constants {
    companion object {
        // Hostname

        const val HOSTNAME = "http://192.168.0.14:8000/"
        private const val AUTH_API = "api-auth/"
        const val LOGIN = "${AUTH_API}login"
        const val LOGOUT = "${AUTH_API}logout"


        // Database

        const val NAME_DATABASE = "flipos_express"

        // Tables

        const val TABLE_USER = "user"
        const val TABLE_ORDER = "order"

        // Columns

        const val ID = "id"
        const val EMAIL = "email"
        const val USERNAME = "username"
        const val PASSWORD = "password"
        const val COST = "cost"
        const val ORDER_COST = "order_cost"
        const val DESCRIPTION = "description"
        const val USER_ID = "user_id"
    }
}