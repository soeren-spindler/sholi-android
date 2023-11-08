package com.spindler.sholi.domain.repository

import com.spindler.sholi.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun create(newArticle: Article): Flow<Article>

    fun getAll(): Flow<List<Article>>
}