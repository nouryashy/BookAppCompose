package com.example.data.data.authors.remote.model
data class AuthorsModel(
    val id: Int,
    val authors: List<AuthorModel>,
){
    data class AuthorModel(
        val id: Int,
        val name: String,
        val birth_year: Int,
        val death_year: Int,

    )
}