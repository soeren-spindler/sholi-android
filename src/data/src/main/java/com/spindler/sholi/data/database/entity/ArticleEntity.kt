package com.spindler.sholi.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "articles"
)
data class ArticleEntity(

    @PrimaryKey
    val id: UUID,

    val name: String,

    val description: String
)