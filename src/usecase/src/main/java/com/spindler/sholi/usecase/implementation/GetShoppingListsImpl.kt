package com.spindler.sholi.usecase.implementation

import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.repository.ShoppingListRepository
import com.spindler.sholi.domain.usecase.shoppinglist.GetShoppingLists
import com.spindler.sholi.domain.util.ShoLiLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetShoppingListsImpl @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository
) : GetShoppingLists {
    override fun invoke(): Flow<List<ShoppingList>> =
        flow {
            val found = shoppingListRepository.getAll()
            ShoLiLog.i(this, "Got all (${found.size})")
            emit(found)
        }
}
