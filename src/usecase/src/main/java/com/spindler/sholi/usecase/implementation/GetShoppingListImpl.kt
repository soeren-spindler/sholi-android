package com.spindler.sholi.usecase.implementation

import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.repository.ShoppingListRepository
import com.spindler.sholi.domain.usecase.shoppinglist.GetShoppingList
import com.spindler.sholi.domain.util.ShoLiLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetShoppingListImpl @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository
) : GetShoppingList {

    override fun invoke(input: String): Flow<ShoppingList?> =
        flow {
            val existing = shoppingListRepository.getById(input)
            ShoLiLog.i(this, "Got id=${existing?.id}")
            emit(existing)
        }
}
