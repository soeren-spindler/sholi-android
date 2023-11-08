package com.spindler.sholi.data.database.repository

import com.spindler.sholi.data.database.dao.ShoppingListDao
import com.spindler.sholi.data.database.entity.EntityMappingExtensions.toShoppingList
import com.spindler.sholi.data.database.entity.EntityMappingExtensions.toShoppingListEntity
import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.repository.ShoppingListRepository
import com.spindler.sholi.domain.util.ShoLiLog
import java.util.UUID
import javax.inject.Inject

class ShoppingListDatabaseRepository @Inject constructor(
    private val shoppingListDao: ShoppingListDao
) : ShoppingListRepository {

    override suspend fun create(newShoppingList: ShoppingList): ShoppingList {
        val newEntity = newShoppingList.toShoppingListEntity()

        ShoLiLog.i(this, "Insert ShoppingList: ${newEntity.name} (${newEntity.id})")
        shoppingListDao.insert(newEntity)

        return newEntity.toShoppingList()
    }

    override suspend fun update(newShoppingList: ShoppingList): ShoppingList {
        val updateEntity = newShoppingList.toShoppingListEntity()

        ShoLiLog.i(this, "Update ShoppingList: ${updateEntity.name} (${updateEntity.id})")
        shoppingListDao.update(updateEntity)

        return updateEntity.toShoppingList()
    }

    override suspend fun getAll(): List<ShoppingList> =
        shoppingListDao
            .getAll()
            .map { entity -> entity.toShoppingList() }

    override suspend fun getById(id: String): ShoppingList? =
        shoppingListDao
            .getById(UUID.fromString(id))
            ?.toShoppingList()
}
