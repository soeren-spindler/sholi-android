package com.spindler.sholi.domain.usecase.shoppinglist

import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.usecase.UseCase

class UpdateShoppingListArgs(
    val id: String,
    val name: String,
    val isCompleted: Boolean
)

interface UpdateShoppingList : UseCase<UpdateShoppingListArgs, ShoppingList>
