package com.infinitesolutions.fliposexpress.data.local.room.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.infinitesolutions.fliposexpress.data.Constants.Companion.COST
import com.infinitesolutions.fliposexpress.data.Constants.Companion.DESCRIPTION
import com.infinitesolutions.fliposexpress.data.Constants.Companion.ID
import com.infinitesolutions.fliposexpress.data.Constants.Companion.ORDER_COST
import com.infinitesolutions.fliposexpress.data.Constants.Companion.TABLE_ORDER
import com.infinitesolutions.fliposexpress.data.Constants.Companion.USER_ID

@Entity(
    tableName = TABLE_ORDER,
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = [ID],
            childColumns = [USER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class OrderEntity(
    id: Int,
    @ColumnInfo(name = COST)
    @SerializedName(COST) @Expose @Keep val cost: Double,
    @ColumnInfo(name = ORDER_COST)
    @SerializedName(ORDER_COST) @Expose @Keep val orderCost: Double,
    @ColumnInfo(name = DESCRIPTION)
    @SerializedName(DESCRIPTION) @Expose @Keep val description: String,
    @ColumnInfo(name = USER_ID)
    @SerializedName(USER_ID) @Expose @Keep val userId: String
) : BaseEntity(id)