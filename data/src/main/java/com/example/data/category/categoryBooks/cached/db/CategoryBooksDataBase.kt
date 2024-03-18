package com.example.data.category.categoryBooks.cached.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.category.categoryBooks.cached.entity.CachedCategoryBook

@Database(entities = [CachedCategoryBook::class], version = 1,exportSchema = true)
@TypeConverters(CategoryBooksConverters::class)

abstract class CategoryBooksDataBase : RoomDatabase() {
    abstract fun categoryBooksDao(): CategoryBooksDao
}