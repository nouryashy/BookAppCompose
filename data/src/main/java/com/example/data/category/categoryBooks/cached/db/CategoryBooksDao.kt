package com.example.data.category.categoryBooks.cached.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.category.categoryBooks.cached.entity.CachedCategoryBook

@Dao
interface CategoryBooksDao {
    @Query("SELECT * FROM categories")
    suspend fun getAllCategoryBooks(): List<CachedCategoryBook>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategoryBooks(categoryBooks: List<CachedCategoryBook>)
    @Query("DELETE FROM categories")
    suspend fun clearCategoryBook()
}