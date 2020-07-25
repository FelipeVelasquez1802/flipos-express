package com.infinitesolutions.fliposexpress.data.local.room.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.data.Constants
import com.infinitesolutions.fliposexpress.data.Constants.Companion.EMAIL
import com.infinitesolutions.fliposexpress.data.Constants.Companion.PASSWORD
import com.infinitesolutions.fliposexpress.data.Constants.Companion.TABLE_USER
import com.infinitesolutions.fliposexpress.data.Constants.Companion.USERNAME

@Entity(tableName = TABLE_USER)
class UserEntity(
    @PrimaryKey @ColumnInfo(name = Constants.ID)
    @SerializedName(Constants.ID) @Expose @Keep val id: String,
    @ColumnInfo(name = USERNAME)
    @SerializedName(USERNAME) @Expose @Keep val username: String? = null,
    @ColumnInfo(name = PASSWORD)
    @SerializedName(PASSWORD) @Expose @Keep val password: String? = null,
    @ColumnInfo(name = EMAIL)
    @SerializedName(EMAIL) @Expose @Keep val email: String? = null
)