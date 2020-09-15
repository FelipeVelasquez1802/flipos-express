package com.infinitesolutions.fliposexpress.data.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.data.Constants
import com.infinitesolutions.fliposexpress.data.Constants.Companion.COST
import com.infinitesolutions.fliposexpress.data.Constants.Companion.CREATION_DATE
import com.infinitesolutions.fliposexpress.data.Constants.Companion.DESCRIPTION
import com.infinitesolutions.fliposexpress.data.Constants.Companion.FINISH
import com.infinitesolutions.fliposexpress.data.Constants.Companion.ID
import com.infinitesolutions.fliposexpress.data.Constants.Companion.ORDER_COST
import com.infinitesolutions.fliposexpress.data.Constants.Companion.TABLE_USER
import com.infinitesolutions.fliposexpress.data.Constants.Companion.USER_ID

@Entity(
    tableName = Constants.TABLE_ORDER,
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = [ID],
            childColumns = [USER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OrderEntity(
    @PrimaryKey @ColumnInfo(name = ID)
    @SerializedName(ID) @Expose @Keep val id: Int,
    @ColumnInfo(name = COST)
    @SerializedName(COST) @Expose @Keep val cost: Double,
    @ColumnInfo(name = ORDER_COST)
    @SerializedName(ORDER_COST) @Expose @Keep val orderCost: Double,
    @ColumnInfo(name = DESCRIPTION)
    @SerializedName(DESCRIPTION) @Expose @Keep val description: String,
    @ColumnInfo(name = USER_ID)
    @SerializedName(TABLE_USER) @Expose @Keep val userId: Int,
    @ColumnInfo(name = CREATION_DATE)
    @SerializedName(CREATION_DATE) @Expose @Keep val creationDate: String,
    @ColumnInfo(name = FINISH)
    @SerializedName(FINISH) @Expose @Keep val finish: Boolean = false
)