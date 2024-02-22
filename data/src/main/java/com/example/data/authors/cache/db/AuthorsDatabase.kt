package com.example.data.authors.cache.db

import androidx.room.*
import com.example.data.authors.cache.entity.CachedAuthors

@Database(entities = [CachedAuthors::class], version = 1,exportSchema = true)
@TypeConverters(AuthorConverters::class)

abstract class AuthorsDatabase : RoomDatabase() {
    abstract fun authorDao(): AuthorsDao
}