package com.infinitesolutions.dataaccess.dto.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.infinitesolutions.dataaccess.Constant.Companion.ID
import com.infinitesolutions.dataaccess.Constant.Companion.KEY
import com.infinitesolutions.dataaccess.Constant.Companion.TABLE_USER
import com.infinitesolutions.dataaccess.Constant.Companion.USERNAME

@Entity(tableName = TABLE_USER)
data class UserDto(
    @PrimaryKey @ColumnInfo(name = ID) val id: Int = -1,
    @ColumnInfo(name = USERNAME) val username: String,
    @ColumnInfo(name = KEY) val token: String
)