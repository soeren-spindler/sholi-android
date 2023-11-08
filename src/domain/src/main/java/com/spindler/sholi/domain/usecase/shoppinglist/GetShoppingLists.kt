package com.spindler.sholi.domain.usecase.shoppinglist

import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.usecase.UseCaseOutputOnly

interface GetShoppingLists : UseCaseOutputOnly<List<ShoppingList>>
