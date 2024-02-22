package com.example.data.authors.data.repository

import com.example.data.authors.data.store.AuthorLocalDataSourse
import com.example.data.authors.data.store.AuthorNetworkDataSource
import com.example.data.authors.remote.mapper.AuthorsResponseModelMapper
import com.example.data.authors.cache.mapper.CachedAuthorsMapper
import com.example.domain.authors.model.Authors
import com.example.domain.authors.repository.AuthorRepository



class AuthorsRepositoryImp(
    private val networkDataSource: AuthorNetworkDataSource,
    private val localDataSource: AuthorLocalDataSourse,
    private val mapperRemote: AuthorsResponseModelMapper,
    private val mapperCached: CachedAuthorsMapper,

    ) : AuthorRepository {
    override suspend fun getAuthors(): List<Authors>
    {
        return try {
            val networkAuthors = networkDataSource.getAuthorsFromApi()
            val authors = networkAuthors.authors
            localDataSource.saveAuthorsToDb(authors.map { mapperCached.mapFromCached(it) })
            authors.map { mapperRemote.mapFromEntity(it) }
        } catch (e: Exception) {
            val cashed = localDataSource.getAuthorsFromDB()
            val cashedAuthors = cashed.map { mapperCached.mapToCached(it) }
            return cashedAuthors.map { mapperRemote.mapFromEntity(it) }
        }
    }
}





















