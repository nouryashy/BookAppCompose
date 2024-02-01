package com.example.data.data.books.cache.db

import androidx.room.TypeConverter
import com.example.data.books.cache.entity.CachedBook
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class BookConverters {

    private val gson = Gson()
    @TypeConverter
    fun fromFormats(formats: CachedBook.CachedFormats): String {
        return formats.imageJPEG
    }

    @TypeConverter
    fun toFormats(image: String): CachedBook.CachedFormats {
        return CachedBook.CachedFormats(image)
    }

        @TypeConverter
    fun fromBookSubjectList(subject: List<String>): String {
        return gson.toJson(subject)
    }

    @TypeConverter
    fun toBookSubjectList(subjectString: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(subjectString, listType)
    }
}