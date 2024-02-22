package com.example.data.authors.data.store

import com.example.data.authors.cache.db.AuthorsDao
import com.example.data.authors.cache.entity.CachedAuthors


class AuthorLocalDataSourse(val authorDao: AuthorsDao) {

    suspend fun getAuthorsFromDB(): List<CachedAuthors> {
        return authorDao.getAllAuthors()
    }

    suspend fun saveAuthorsToDb(authors: List<CachedAuthors>) {
        authorDao.insertAuthors(authors)
    }

    suspend fun deleteAuthor() {
        authorDao.clearAuthors()
    }

}