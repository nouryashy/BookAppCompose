package com.example.bookappcompose.di

import com.example.data.authors.cache.db.AuthorsDao
import com.example.data.authors.cache.mapper.CachedAuthorsMapper
import com.example.data.authors.data.repository.AuthorsRepositoryImp
import com.example.data.authors.data.store.AuthorLocalDataSourse
import com.example.data.authors.data.store.AuthorNetworkDataSource
import com.example.data.authors.remote.AuthorsServices
import com.example.data.authors.remote.mapper.AuthorsResponseModelMapper
import com.example.domain.authors.repository.AuthorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthorRepositoryModule {

    @Provides
    fun provideAuthorNetworkDataSource(apiService: AuthorsServices): AuthorNetworkDataSource {
        return AuthorNetworkDataSource(apiService)
    }

    @Provides
    fun provideAuthorLocalDataSource(dao: AuthorsDao): AuthorLocalDataSourse {
        return AuthorLocalDataSourse(dao)
    }

    @Provides
    fun provideCachedAuthorMapper(): CachedAuthorsMapper {
        return CachedAuthorsMapper
    }


    @Provides
    fun provideAuthorMapper(): AuthorsResponseModelMapper {
        return AuthorsResponseModelMapper
    }


    @Provides
    fun provideAuthorRepository(
        networkDataSource: AuthorNetworkDataSource,
        localDataSourse: AuthorLocalDataSourse,
        mapperRemote: AuthorsResponseModelMapper,
        mapperCached: CachedAuthorsMapper

    ): AuthorRepository {
        return AuthorsRepositoryImp(networkDataSource, localDataSourse, mapperRemote, mapperCached)
    }
}