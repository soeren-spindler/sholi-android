package com.spindler.sholi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.spindler.sholi.data.database.converters.DateConverter
import com.spindler.sholi.data.database.converters.UUIDConverter
import com.spindler.sholi.data.database.dao.ArticleDao
import com.spindler.sholi.data.database.dao.ShoppingListDao
import com.spindler.sholi.data.database.entity.ArticleEntity
import com.spindler.sholi.data.database.entity.ShoppingListEntity
import com.spindler.sholi.data.database.entity.ShoppingListItemEntity

@Database(
    entities = [
        ArticleEntity::class,
        ShoppingListEntity::class,
        ShoppingListItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    UUIDConverter::class,
    DateConverter::class
)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun shoppingListDao(): ShoppingListDao

    abstract fun articleDao(): ArticleDao
}