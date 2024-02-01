package com.example.data.books.data.repository

import com.example.data.books.cache.mapper.CachedBookMapper
import com.example.data.books.data.store.BookLocalDataSource
import com.example.data.books.data.store.BookNetworkDataSource
import com.example.data.books.remote.mapper.BookResponseModelMapper
import com.example.domain.books.model.Book
import com.example.domain.books.repository.BooksRepository


class BooksRepositoryImp(
    private val networkDataSource: BookNetworkDataSource,
    private val localDataSource: BookLocalDataSource,
    private val mapperRemote: BookResponseModelMapper,
    private val mapperCached: CachedBookMapper
) : BooksRepository {
    override suspend fun getBooks(page: Int): List<Book> {
        return try {
            val networkBooks = networkDataSource.getBooksFromApi(page)
            val books = networkBooks.books
            localDataSource.saveBooksToDb(books.map { mapperCached.mapFromCached(it) })
            books.map { mapperRemote.mapFromEntity(it) }
        } catch (e: Exception) {
            val cashed = localDataSource.getBookFromDB()
            val cashedBooks = cashed.map { mapperCached.mapToCached(it) }
            cashedBooks.map { mapperRemote.mapFromEntity(it) }
        }
    }
}



























