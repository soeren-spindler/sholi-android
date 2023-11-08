package com.spindler.sholi.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spindler.sholi.data.database.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(item: ArticleEntity)

    @Query("SELECT * FROM articles ORDER BY name ASC")
    fun getAll(): Flow<List<ArticleEntity>>
}