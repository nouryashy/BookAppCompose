package com.example.domain.books.repository

import com.example.domain.books.model.Book

interface BooksRepository {
    suspend fun getBooks(page: Int): List<Book>
}