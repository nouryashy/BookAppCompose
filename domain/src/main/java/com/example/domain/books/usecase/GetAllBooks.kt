package com.example.domain.books.usecase

import com.example.domain.books.repository.BooksRepository
import javax.inject.Inject

class GetAllBooks  @Inject constructor(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(page: Int) = booksRepository.getAllBooks(page)
}