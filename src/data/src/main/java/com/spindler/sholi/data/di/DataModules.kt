package com.spindler.sholi.data.di

import android.content.Context
import androidx.room.Room
import com.spindler.sholi.data.database.ShoppingListDatabase
import com.spindler.sholi.data.database.dao.ArticleDao
import com.spindler.sholi.data.database.dao.ShoppingListDao
import com.spindler.sholi.data.database.repository.ArticleDatabaseRepository
import com.spindler.sholi.data.database.repository.ShoppingListDatabaseRepository
import com.spindler.sholi.domain.repository.ArticleRepository
import com.spindler.sholi.domain.repository.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModules {
    @Provides
    @Singleton
    fun provideShoppingListDatabase(
        @ApplicationContext appContext: Context
    ): ShoppingListDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = ShoppingListDatabase::class.java,
            name = "ShoppingList"
        ).build()
    }

    @Provides
    fun provideArticleDao(
        database: ShoppingListDatabase
    ): ArticleDao = database.articleDao()

    @Provides
    fun provideShoppingListDao(
        database: ShoppingListDatabase
    ): ShoppingListDao = database.shoppingListDao()

    @Provides
    fun provideArticleRepository(
        dao: ArticleDao
    ): ArticleRepository = ArticleDatabaseRepository(dao)

    @Provides
    fun provideShoppingListRepository(
        dao: ShoppingListDao
    ): ShoppingListRepository = ShoppingListDatabaseRepository(dao)
}