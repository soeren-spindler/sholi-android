package com.spindler.sholi.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import java.util.UUID

@Entity(
    tableName = "shopping_list_items",
    primaryKeys = ["shoppingListId", "articleId"],
    foreignKeys = [
        ForeignKey(
            entity = ShoppingListEntity::class,
            parentColumns = ["id"],
            childColumns = ["shoppingListId"]
        ),
        ForeignKey(
            entity = ArticleEntity::class,
            parentColumns = ["id"],
            childColumns = ["articleId"]
        )
    ],
)
data class ShoppingListItemEntity(

    @ColumnInfo(index = true)
    val shoppingListId: UUID,

    @ColumnInfo(index = true)
    val articleId: UUID,

    val amountNeeded: Int?,

    val amountCurrent: Int?,

    val done: Boolean
)