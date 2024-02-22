package com.example.data.data.authors.remote.model

import com.google.gson.annotations.SerializedName


data class AuthorsResponseModel(

    @SerializedName("results")
    val authors: List<AuthorsModel>
)