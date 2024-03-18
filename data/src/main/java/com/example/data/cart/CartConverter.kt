package com.example.data.cart

import androidx.room.TypeConverter
import com.example.data.book.cache.entity.CachedBook
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CartConverter {

    private val gson = Gson()


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