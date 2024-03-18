package com.example.data.category.categoryBooks.data.repository

import com.example.data.category.categoryBooks.cached.mapper.CachedCategoryBookMapper
import com.example.data.category.categoryBooks.data.store.CategoryBooksLocalDataSource
import com.example.data.category.categoryBooks.data.store.CategoryBooksNetworkDataSource
import com.example.data.category.categoryBooks.remote.mapper.CategoryBookResponseModelMapper
import com.example.domain.category.categorybooks.model.CategoryBook
import com.example.domain.category.categorybooks.repository.CategoryBooksRepository


class CategoryBooksRepositoryImp(
    private val networkDataSource: CategoryBooksNetworkDataSource,
    private val localDataSource: CategoryBooksLocalDataSource,
    private val mapperRemote: CategoryBookResponseModelMapper,
    private val mapperCached: CachedCategoryBookMapper
) : CategoryBooksRepository {
    override suspend fun getBooksAccordingToCategories(topic: String): List<CategoryBook> {
        return try {
            val networkBooks = networkDataSource.getCategoryFromApi(topic)
            val catBooks = networkBooks.categoryBooks
            localDataSource.saveCategoryBooksToDb(catBooks.map { mapperCached.mapFromCached(it) })
            catBooks.map { mapperRemote.mapFromEntity(it) }
        } catch (e: Exception) {
            val cashed = localDataSource.getAllCategoryBooks()
            val cashedBooks = cashed.map { mapperCached.mapToCached(it) }
            cashedBooks.map { mapperRemote.mapFromEntity(it) }

        }
    }

}



























