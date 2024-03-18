package com.example.data.cart

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.books.model.Book
@Entity(tableName = "cart_items")
data class CashedCart(
    @PrimaryKey
    val id: Int,
    val title: String,
    val imageUrl: String,
    val quantity: Int
){

}