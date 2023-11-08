package com.spindler.sholi.data.database.repository

import com.spindler.sholi.data.database.dao.ArticleDao
import com.spindler.sholi.data.database.entity.ArticleEntity
import com.spindler.sholi.data.database.entity.EntityMappingExtensions.toArticle
import com.spindler.sholi.domain.model.Article
import com.spindler.sholi.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class ArticleDatabaseRepository @Inject constructor(
    private val articleDao: ArticleDao
) : ArticleRepository {

    override fun create(newArticle: Article): Flow<Article> {
        val newEntity = ArticleEntity(
            id = UUID.randomUUID(),
            name = newArticle.name,
            description = newArticle.description
        )

        return flow {
            articleDao.insert(newEntity)
            emit(newEntity.toArticle())
        }
    }

    override fun getAll(): Flow<List<Article>> =
        articleDao
            .getAll()
            .map { entities ->
                entities.map { entity -> entity.toArticle() }
            }
}