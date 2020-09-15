package com.infinitesolutions.fliposexpress.data.local.room.dao

import androidx.room.*
import com.infinitesolutions.fliposexpress.data.Constants.Companion.TABLE_ORDER
import com.infinitesolutions.fliposexpress.data.entities.OrderEntity
import io.reactivex.Single

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(order: OrderEntity): Single<Long>

    @Query("SELECT * FROM `$TABLE_ORDER`")
    fun select(): Single<List<OrderEntity>>

    @Query("SELECT * FROM `$TABLE_ORDER` WHERE id=:id")
    fun select(id: Int): Single<OrderEntity?>

    @Query("SELECT * FROM `$TABLE_ORDER` WHERE user_id=:userId")
    fun selectByUser(userId: Int): Single<List<OrderEntity>>

    @Query("SELECT * FROM `$TABLE_ORDER` LIMIT 1")
    fun selectFirst(): Single<OrderEntity?>

    @Update
    fun update(vararg order: OrderEntity): Single<Int>
}