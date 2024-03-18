package com.example.domain.cart.model

import com.example.domain.books.model.Book

data class Cart(

    val id: Int,
    val title: String,
    val imageUrl: String,
    val quantity: Int){
}