package com.spindler.sholi.domain.repository

import com.spindler.sholi.domain.model.ShoppingList

interface ShoppingListRepository {

    suspend fun create(newShoppingList: ShoppingList): ShoppingList

    suspend fun update(newShoppingList: ShoppingList): ShoppingList

    suspend fun getAll(): List<ShoppingList>

    suspend fun getById(id: String): ShoppingList?
}
