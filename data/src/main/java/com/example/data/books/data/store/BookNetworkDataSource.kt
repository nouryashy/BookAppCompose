package com.example.data.books.data.store

import com.example.data.books.remote.model.BooksResponseModel
import com.example.data.books.remote.service.BooksServices


class BookNetworkDataSource(val apiServices: BooksServices) {
    suspend fun getAllBooksFromApi(page: Int): BooksResponseModel = apiServices.getBooks(page)
    suspend fun getTopBookFromApi(): BooksResponseModel = apiServices.getTopBooks()
}