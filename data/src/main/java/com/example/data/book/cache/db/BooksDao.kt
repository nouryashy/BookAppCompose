package com.example.data.book.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.book.cache.entity.CachedBook


@Dao
interface BooksDao {
    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<CachedBook>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBooks(books: List<CachedBook>)


    @Query("DELETE FROM books")
    suspend fun clearBooks()

    @Query("SELECT * FROM books")
    suspend fun getTopBooks(): List<CachedBook>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTopBooks(books: List<CachedBook>)

}

