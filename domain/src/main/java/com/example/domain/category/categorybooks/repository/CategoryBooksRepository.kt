package com.example.domain.category.categorybooks.repository

import com.example.domain.category.categorybooks.model.CategoryBook

interface CategoryBooksRepository {
    suspend fun getBooksAccordingToCategories(topic: String): List<CategoryBook>
}