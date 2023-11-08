package com.spindler.sholi.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.spindler.sholi.data.database.entity.ShoppingListEntity
import java.util.UUID

@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(item: ShoppingListEntity)

    @Update
    suspend fun update(item: ShoppingListEntity): Int

    @Delete
    suspend fun delete(item: ShoppingListEntity)

    @Query("SELECT * FROM shopping_lists WHERE id = :id")
    suspend fun getById(id: UUID): ShoppingListEntity?

    @Query("SELECT * FROM shopping_lists ORDER BY name ASC")
    suspend fun getAll(): List<ShoppingListEntity>

//    @Query(
//        "SELECT * FROM shopping_lists WHERE id = :id"
//    )
//    fun getWithItems(id: UUID): Flow<Map<ShoppingListEntity, List<ShoppingListItemEntity>>>
}
