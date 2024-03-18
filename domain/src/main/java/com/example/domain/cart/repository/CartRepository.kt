package com.example.domain.cart.repository

import com.example.domain.books.model.Book
import com.example.domain.cart.model.Cart

interface CartRepository {
//    suspend fun addBookToCart(book: Book)
//    suspend fun removeBookFromCart(bookId: Int, quantity: Int)
//    suspend fun getAllBookCartItems(): List<Cart>
//    suspend fun loadAllBooksToCart(): List<Cart>

    suspend fun getAllBookInCart(): List<Cart>
    suspend fun addBookToCart(cart: Cart)
    suspend fun updateBookInCart(cart: Cart)
    suspend fun removeBookFromCart(cart: Cart)
    suspend fun clearCart()
}