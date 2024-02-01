package com.example.data.books.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.books.cache.entity.CachedBook


@Dao
interface BooksDao {
    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<CachedBook>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBooks(books: List<CachedBook>)


    @Query("DELETE FROM books")
    suspend fun clearBooks()
}

