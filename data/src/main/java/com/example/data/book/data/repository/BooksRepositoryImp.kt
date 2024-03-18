package com.example.data.book.data.repository

import com.example.data.book.cache.mapper.CachedBookMapper
import com.example.data.book.data.store.BookLocalDataSource
import com.example.data.book.data.store.BookNetworkDataSource
import com.example.data.book.remote.mapper.BookResponseModelMapper
import com.example.domain.books.model.Book
import com.example.domain.books.repository.BooksRepository


class BooksRepositoryImp(
    private val networkDataSource: BookNetworkDataSource,
    private val localDataSource: BookLocalDataSource,
    private val mapperRemote: BookResponseModelMapper,
    private val mapperCached: CachedBookMapper
) : BooksRepository {
    override suspend fun getAllBooks(page: Int): List<Book> {
        return try {
            val networkBooks = networkDataSource.getAllBooksFromApi(page)
            val books = networkBooks.books
            localDataSource.saveAllBooksToDb(books.map { mapperCached.mapFromCached(it) })
            books.map { mapperRemote.mapFromEntity(it) }
        } catch (e: Exception) {
            val cashed = localDataSource.getAllBookFromDB()
            val cashedBooks = cashed.map { mapperCached.mapToCached(it) }
            cashedBooks.map { mapperRemote.mapFromEntity(it) }
        }
    }

    override suspend fun getTopBooks(): List<Book> {
        return try {
            val networkBooks = networkDataSource.getTopBookFromApi()
            val books = networkBooks.books
            localDataSource.saveTopBooksToDb(books.map { mapperCached.mapFromCached(it) })
            books.map { mapperRemote.mapFromEntity(it) }
        } catch (e: Exception) {
            val cashed = localDataSource.getTopBookFromDB()
            val cashedBooks = cashed.map { mapperCached.mapToCached(it) }
            cashedBooks.map { mapperRemote.mapFromEntity(it) }
        }
    }


}



























