package com.spindler.sholi.usecase.di

import com.spindler.sholi.domain.repository.ShoppingListRepository
import com.spindler.sholi.domain.usecase.shoppinglist.CreateShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.GetShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.GetShoppingLists
import com.spindler.sholi.domain.usecase.shoppinglist.UpdateShoppingList
import com.spindler.sholi.usecase.implementation.CreateShoppingListImpl
import com.spindler.sholi.usecase.implementation.GetShoppingListImpl
import com.spindler.sholi.usecase.implementation.GetShoppingListsImpl
import com.spindler.sholi.usecase.implementation.UpdateShoppingListImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModules {
    @Provides
    fun provideCreateShoppingList(
        repository: ShoppingListRepository
    ): CreateShoppingList = CreateShoppingListImpl(repository)

    @Provides
    fun provideUpdateShoppingList(
        repository: ShoppingListRepository
    ): UpdateShoppingList = UpdateShoppingListImpl(repository)

    @Provides
    fun provideGetShoppingLists(
        repository: ShoppingListRepository
    ): GetShoppingLists = GetShoppingListsImpl(repository)

    @Provides
    fun provideGetShoppingList(
        repository: ShoppingListRepository
    ): GetShoppingList = GetShoppingListImpl(repository)
}
