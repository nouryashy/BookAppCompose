package com.example.data.category.categoryBooks.cached.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CachedCategoryBook(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val formats: CachedFormatsCat,
    val subjects: List<String>,
    val title: String,
) {
    data class CachedFormatsCat(
        val imageJPEG: String,
    )
}