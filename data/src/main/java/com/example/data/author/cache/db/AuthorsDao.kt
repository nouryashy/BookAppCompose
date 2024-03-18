package com.example.data.author.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.author.cache.entity.CachedAuthors


@Dao
interface AuthorsDao {
    @Query("SELECT * FROM authors")
    suspend  fun getAllAuthors(): List<CachedAuthors>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insertAuthors(authors: List<CachedAuthors>)


    @Query("DELETE FROM authors")
    suspend  fun clearAuthors()
}

