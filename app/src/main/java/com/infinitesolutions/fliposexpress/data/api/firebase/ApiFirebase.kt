package com.infinitesolutions.fliposexpress.data.api.firebase

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ApiFirebase {
    companion object {
        fun auth() = Firebase.auth
        fun reference()=Firebase.database.reference
    }
}