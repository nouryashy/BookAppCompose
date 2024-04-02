package com.example.data.book.data.repository

import android.content.ContentValues
import android.util.Log
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
    override suspend fun getFavoriteBooks(): List<Book> {
        return try {
            val cachedBooks = localDataSource.getFavoriteBooks()
            val cashedBooks = cachedBooks.map { mapperCached.mapToCached(it) }
            val favBook=  cashedBooks.map { mapperRemote.mapFromEntity(it) }
            Log.d(ContentValues.TAG, "Fetched ${favBook.size} favorite books")
            favBook
        }   catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }

    }


    override suspend fun removeFavorite(book: Book) {
        localDataSource.removeFromFavorites(
            mapperCached.mapFromCached(mapperRemote.mapToEntity(book)))
    }
    override suspend fun toggleFavorite(book: Book) {
        try {
            if (book.isFavorite) {
                localDataSource.removeFromFavorites(
                    mapperCached.mapFromCached(
                        mapperRemote.mapToEntity(
                            book
                        )
                    )
                )
            } else { localDataSource.addToFavorites(mapperCached.mapFromCached(mapperRemote.mapToEntity(
                Book(book.id,book.formats,book.subjects,book.title,true))))
            }

            book.isFavorite = !book.isFavorite
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, "Error toggling favorite status", e)
        }
    }
}



























