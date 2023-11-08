package com.spindler.sholi.usecase.implementation

import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.repository.ShoppingListRepository
import com.spindler.sholi.domain.usecase.shoppinglist.UpdateShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.UpdateShoppingListArgs
import com.spindler.sholi.domain.util.ShoLiLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date
import javax.inject.Inject

class UpdateShoppingListImpl @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository
) : UpdateShoppingList {

    override fun invoke(input: UpdateShoppingListArgs): Flow<ShoppingList> =
        flow {
            val existing = shoppingListRepository.getById(input.id)
            if (existing != null) {
                existing.updatedOn = Date()
                existing.name = input.name
                existing.isCompleted = input.isCompleted

                val updated = shoppingListRepository.update(existing)
                ShoLiLog.i(this, "Updated id=${updated.id}")
                emit(updated)
            } else {
                throw Exception("No Shopping List found to be updated. Failed for id=${input.id}")
            }
        }

}
