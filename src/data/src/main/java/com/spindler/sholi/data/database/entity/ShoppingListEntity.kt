package com.spindler.sholi.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(
    tableName = "shopping_lists"
)
data class ShoppingListEntity(

    @PrimaryKey
    val id: UUID,

    val name: String,

    val createdOn: Date,

    val updatedOn: Date,

    val completed: Boolean
)