package com.infinitesolutions.dataaccess.repository.user.local

import androidx.room.*
import com.infinitesolutions.dataaccess.Constant.Companion.KEY
import com.infinitesolutions.dataaccess.Constant.Companion.TABLE_USER
import com.infinitesolutions.dataaccess.dto.local.UserDto

@Dao
interface UserService {

    companion object {
        private const val SELECT = "SELECT * FROM $TABLE_USER"
        private const val SELECT_TOKEN = "SELECT $KEY FROM $TABLE_USER"
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserDto): Long

    @Query("$SELECT WHERE id=:id")
    fun select(id: Int): UserDto?

    @Query("$SELECT_TOKEN LIMIT 1")
    fun selectToken(): String?

    @Update
    fun update(vararg user: UserDto): Int
}