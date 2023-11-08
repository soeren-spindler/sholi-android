package com.spindler.sholi.domain.model

import java.util.Date
import java.util.UUID

class ShoppingList(
    val id: UUID,
    var name: String,
    val createdOn: Date,
    var updatedOn: Date,
    var isCompleted: Boolean = false
)
