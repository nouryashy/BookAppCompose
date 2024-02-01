package com.example.data.data.books.cache.db

import androidx.room.*
import com.example.data.books.cache.db.BooksDao
import com.example.data.data.books.cache.entity.CachedBook

@Database(entities = [CachedBook::class], version = 1,exportSchema = true)
@TypeConverters(BookConverters::class)

abstract class BooksDatabase : RoomDatabase() {
    abstract fun BooksDao(): BooksDao
}