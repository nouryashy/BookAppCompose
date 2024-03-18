package com.example.data.book.cache.db

import androidx.room.*
import com.example.data.book.cache.entity.CachedBook


@Database(entities = [CachedBook::class], version = 1,exportSchema = true)
@TypeConverters(BookConverters::class)

abstract class BooksDatabase : RoomDatabase() {
    abstract fun BooksDao(): BooksDao
}