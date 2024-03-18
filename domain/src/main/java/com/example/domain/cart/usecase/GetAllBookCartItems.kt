package com.example.domain.cart.usecase

import com.example.domain.cart.repository.CartRepository
import javax.inject.Inject

class GetAllBookCartItems @Inject constructor(private val cartBookRepository: CartRepository) {
//    suspend operator fun invoke() =
//        cartBookRepository.getAllBookCartItems()

    suspend operator fun invoke() =
        cartBookRepository.getAllBookInCart()
}