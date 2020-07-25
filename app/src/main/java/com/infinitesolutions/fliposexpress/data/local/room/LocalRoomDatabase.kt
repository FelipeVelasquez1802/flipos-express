package com.infinitesolutions.fliposexpress.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.infinitesolutions.fliposexpress.data.Constants.Companion.NAME_DATABASE
import com.infinitesolutions.fliposexpress.data.local.room.dao.OrderDao
import com.infinitesolutions.fliposexpress.data.local.room.dao.UserDao
import com.infinitesolutions.fliposexpress.data.local.room.entities.OrderEntity
import com.infinitesolutions.fliposexpress.data.local.room.entities.UserEntity

@Database(
    entities = [UserEntity::class, OrderEntity::class],
    version = 2,
    exportSchema = false
)
abstract class LocalRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun orderDao(): OrderDao

    companion object {
        @Volatile
        private var INSTANCE: LocalRoomDatabase? = null

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