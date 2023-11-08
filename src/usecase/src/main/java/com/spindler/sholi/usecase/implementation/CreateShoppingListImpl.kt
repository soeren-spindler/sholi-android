package com.spindler.sholi.usecase.implementation

import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.repository.ShoppingListRepository
import com.spindler.sholi.domain.usecase.shoppinglist.CreateShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.CreateShoppingListArgs
import com.spindler.sholi.domain.util.ShoLiLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date
import java.util.UUID
import javax.inject.Inject

class CreateShoppingListImpl @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository
) : CreateShoppingList {

    override fun invoke(input: CreateShoppingListArgs): Flow<ShoppingList> =
        flow {
            val now = Date()
            val created = shoppingListRepository.create(
                ShoppingList(
                    id = UUID.randomUUID(),
                    name = input.name,
                    createdOn = now,
                    updatedOn = now,
                    isCompleted = false
                )
            )
            ShoLiLog.i(this, "Created id=${created.id}")
            emit(created)
        }

}
