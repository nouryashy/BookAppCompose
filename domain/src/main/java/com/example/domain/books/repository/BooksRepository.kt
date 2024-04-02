package com.example.domain.books.repository

import com.example.domain.books.model.Book

interface BooksRepository {
    suspend fun getAllBooks(page: Int): List<Book>
    suspend fun getTopBooks(): List<Book>

    suspend fun toggleFavorite(book: Book)
    suspend fun getFavoriteBooks(): List<Book>
    suspend fun removeFavorite(book: Book)
}