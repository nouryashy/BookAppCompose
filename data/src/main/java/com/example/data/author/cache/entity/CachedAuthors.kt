package com.example.data.author.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class CachedAuthors(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val authors: List<CachedAuthor>,
) {
    data class CachedAuthor(
        @PrimaryKey
        val id: Int,
        val name: String,
        val birth_year: Int,
        val death_year: Int
    )
}
