package com.example.data.cart.repository


import com.example.data.cart.mapper.CachedCartMapper
import com.example.data.cart.store.CartManager
import com.example.domain.books.model.Book
import com.example.domain.cart.model.Cart
import com.example.domain.cart.repository.CartRepository


class CartRepositoryImp(
    private val cartManager: CartManager,
    private val mapper: CachedCartMapper
) : CartRepository {

    override suspend fun getAllBookInCart(): List<Cart> {

        return cartManager.getAllCartItems().map { cashedCart ->
            mapper.mapToCached(cashedCart)
        }
    }

    override suspend fun addBookToCart(cart: Cart) {
        val cashedCart = mapper.mapFromCached(cart)
        cartManager.insertCartItem(cashedCart)
    }

    override suspend fun updateBookInCart(cart: Cart) {
        val cashedCart = mapper.mapFromCached(cart)
        cartManager.updateCartItem(cashedCart)
    }


    override suspend fun removeBookFromCart(cart: Cart) {
        val cashedCart = mapper.mapFromCached(cart)
        cartManager.deleteCartItem(cashedCart)
    }

    override suspend fun clearCart() {
        cartManager.clearCart()
    }

    //        override suspend fun addBookToCart(book: Book) {
//        cartManager.addBookToCart(book)
//    }
//
//    override suspend fun removeBookFromCart(bookId: Int, quantity: Int) {
//        cartManager.removeBookFromCart(bookId, quantity)
//    }
//
//    override suspend fun getAllBookCartItems(): List<Cart> {
//        return cartManager.getAllBookCartItems()
////        return cartManager.loadCartItemsFromSharedPreferences()
//    }
//
//    override suspend fun loadAllBooksToCart(): List<Cart> {
//        return cartManager.loadCartItemsFromSharedPreferences()
//    }

}