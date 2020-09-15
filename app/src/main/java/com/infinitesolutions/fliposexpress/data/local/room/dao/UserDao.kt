package com.infinitesolutions.fliposexpress.data.local.room.dao

import androidx.room.*
import com.infinitesolutions.fliposexpress.data.Constants.Companion.TABLE_USER
import com.infinitesolutions.fliposexpress.data.entities.UserEntity
import io.reactivex.Single

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserEntity): Single<Long>

    @Query("SELECT * FROM $TABLE_USER")
    fun select(): Single<List<UserEntity>>

    @Query("SELECT * FROM $TABLE_USER WHERE id=:id")
    fun select(id: Int): Single<UserEntity?>

    @Query("SELECT * FROM $TABLE_USER WHERE username=:username LIMIT 1")
    fun selectByUsername(username: String): Single<UserEntity?>

    @Query("SELECT * FROM $TABLE_USER LIMIT 1")
    fun selectFirst(): Single<UserEntity?>

    @Update
    fun update(vararg user: UserEntity): Single<Int>
}