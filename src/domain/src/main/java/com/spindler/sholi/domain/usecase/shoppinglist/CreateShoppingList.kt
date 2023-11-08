package com.spindler.sholi.domain.usecase.shoppinglist

import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.usecase.UseCase

class CreateShoppingListArgs(
    val name: String
)

interface CreateShoppingList : UseCase<CreateShoppingListArgs, ShoppingList>
