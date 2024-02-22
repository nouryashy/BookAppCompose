package com.example.data.books.data.store

import com.example.data.books.cache.entity.CachedBook
import com.example.data.books.cache.db.BooksDao

class BookLocalDataSource(val bookDao: BooksDao) {
    suspend  fun getAllBookFromDB(): List<CachedBook> {
        return bookDao.getAllBooks()
    }

    suspend  fun saveAllBooksToDb(books: List<CachedBook>) {
        bookDao.insertBooks(books)
    }

    suspend  fun deleteBooks(){
        return bookDao.clearBooks()
    }

    suspend  fun getTopBookFromDB(): List<CachedBook> {
        return bookDao.getTopBooks()
    }

    suspend  fun saveTopBooksToDb(books: List<CachedBook>) {
        bookDao.insertTopBooks(books)
    }


}