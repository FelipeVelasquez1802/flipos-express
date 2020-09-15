package com.infinitesolutions.fliposexpress.data.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.data.Constants.Companion.EMAIL
import com.infinitesolutions.fliposexpress.data.Constants.Companion.ID
import com.infinitesolutions.fliposexpress.data.Constants.Companion.KEY
import com.infinitesolutions.fliposexpress.data.Constants.Companion.PASSWORD
import com.infinitesolutions.fliposexpress.data.Constants.Companion.TABLE_USER
import com.infinitesolutions.fliposexpress.data.Constants.Companion.USERNAME

@Entity(tableName = TABLE_USER)
data class UserEntity(
    @PrimaryKey @ColumnInfo(name = ID)
    @SerializedName(ID) @Expose @Keep val id: Int? = null,
    @ColumnInfo(name = USERNAME)
    @SerializedName(USERNAME) @Expose @Keep val username: String? = null,
    @ColumnInfo(name = EMAIL)
    @SerializedName(EMAIL) @Expose @Keep val email: String? = null,
    @ColumnInfo(name = PASSWORD)
    @SerializedName(PASSWORD) @Expose @Keep val password: String? = null,
    @ColumnInfo(name = KEY)
    @SerializedName(KEY) @Expose @Keep val key: String? = null
)