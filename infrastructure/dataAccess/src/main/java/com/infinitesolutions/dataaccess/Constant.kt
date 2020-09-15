package com.infinitesolutions.dataaccess

class Constant {
    companion object {
        const val ID = "id"
        const val USERNAME = "username"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val KEY = "key"
        const val USER = "user"
        const val USER_ID = "userId"
        const val AUTH = "auth"

        const val HOSTNAME = "http://192.168.0.14:8000/"

        // User

        private const val AUTH_API = "api-auth/"
        const val LOGIN = "${AUTH_API}login"
        const val LOGOUT = "${AUTH_API}logout"
    }
}