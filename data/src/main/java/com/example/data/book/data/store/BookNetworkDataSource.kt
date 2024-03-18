package com.example.data.book.data.store

import com.example.data.book.remote.model.BooksResponseModel
import com.example.data.book.remote.service.BooksServices


class BookNetworkDataSource(val apiServices: BooksServices) {
    suspend fun getAllBooksFromApi(page: Int): BooksResponseModel = apiServices.getBooks(page)
    suspend fun getTopBookFromApi(): BooksResponseModel = apiServices.getTopBooks()
}