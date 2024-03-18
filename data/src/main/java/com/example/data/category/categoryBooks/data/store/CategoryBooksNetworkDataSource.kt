package com.example.data.category.categoryBooks.data.store

import com.example.data.category.categoryBooks.remote.model.CategoryBooksResponseModel
import com.example.data.category.categoryBooks.remote.services.CategoryBooksServices

class CategoryBooksNetworkDataSource(val apiServices: CategoryBooksServices) {
    suspend fun getCategoryFromApi(topic: String): CategoryBooksResponseModel =
        apiServices.getCategoryBooks(topic)
}