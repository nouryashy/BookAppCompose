package com.example.data.book.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class CachedBook(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val formats: CachedFormats,
    val subjects: List<String>,
    val title: String,


)
{
    data class CachedFormats (
        val imageJPEG: String,
    )

}
