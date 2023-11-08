package com.spindler.sholi.data.database.entity

import com.spindler.sholi.domain.model.Article
import com.spindler.sholi.domain.model.ShoppingList

object EntityMappingExtensions {

    fun ArticleEntity.toArticle(): Article =
        Article(
            id = id.toString(),
            name = name,
            description = description
        )

    fun ShoppingListEntity.toShoppingList(): ShoppingList =
        ShoppingList(
            id = id,
            name = name,
            createdOn = createdOn,
            updatedOn = updatedOn,
            isCompleted = completed
        )

    fun ShoppingList.toShoppingListEntity(): ShoppingListEntity =
        ShoppingListEntity(
            id = id,
            name = name,
            createdOn = createdOn,
            updatedOn = updatedOn,
            completed = isCompleted
        )
}
