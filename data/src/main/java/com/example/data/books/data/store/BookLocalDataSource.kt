package com.example.data.books.data.store

import com.example.data.books.cache.entity.CachedBook
import com.example.data.books.cache.db.BooksDao

class BookLocalDataSource(val bookDao: BooksDao) {
    suspend  fun getBookFromDB(): List<CachedBook> {
        return bookDao.getAllBooks()
    }

    suspend  fun saveBooksToDb(books: List<CachedBook>) {
        bookDao.insertBooks(books)
    }

    suspend  fun deleteBooks(){
        return bookDao.clearBooks()
    }
}