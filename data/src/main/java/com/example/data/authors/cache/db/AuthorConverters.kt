package com.example.data.authors.cache.db

import androidx.room.TypeConverter
import com.example.data.authors.cache.entity.CachedAuthors
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AuthorConverters {

    private val gson = Gson()


    @TypeConverter
    fun fromAuthorsList(authors: List<CachedAuthors.CachedAuthor>): String {
        return gson.toJson(authors)
    }

    @TypeConverter
    fun toAuthorsList(authorsString: String): List<CachedAuthors.CachedAuthor> {
        val listType = object : TypeToken<List<CachedAuthors.CachedAuthor>>() {}.type
        return gson.fromJson(authorsString, listType)
    }
}