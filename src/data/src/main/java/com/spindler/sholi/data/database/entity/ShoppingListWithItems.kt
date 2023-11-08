package com.spindler.sholi.data.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ShoppingListWithItems(

    @Embedded
    val shoppingList: ShoppingListEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "shoppingListId"
    )
    val items: List<ShoppingListItemEntity>
)