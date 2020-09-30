package com.infinitesolutions.dataaccess.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.infinitesolutions.dataaccess.dto.local.UserDto
import com.infinitesolutions.dataaccess.repository.user.local.UserService

@Database(
    entities = [UserDto::class],
    version = 1,
    exportSchema = false
)
abstract class LocalRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserService

    companion object {
        @Volatile
        private var INSTANCE: LocalRoomDatabase? = null
        private const val NAME_DATABASE = "flipos_express"

        fun getDatabase(context: Context): LocalRoomDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalRoomDatabase::class.java,
                    NAME_DATABASE
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return INSTANCE as LocalRoomDatabase
            }
        }
    }
}