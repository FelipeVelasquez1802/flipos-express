package com.infinitesolutions.fliposexpress.data.local.room.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.data.Constants.Companion.ID

open class BaseEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = ID)
    @SerializedName(ID) @Expose @Keep val id: Int
)