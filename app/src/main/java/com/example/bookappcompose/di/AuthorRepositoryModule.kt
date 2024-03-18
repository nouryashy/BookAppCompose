package com.example.bookappcompose.di

import com.example.data.author.cache.db.AuthorsDao
import com.example.data.author.cache.mapper.CachedAuthorsMapper
import com.example.data.author.data.repository.AuthorsRepositoryImp
import com.example.data.author.data.store.AuthorLocalDataSourse
import com.example.data.author.data.store.AuthorNetworkDataSource
import com.example.data.author.remote.AuthorsServices
import com.example.data.author.remote.mapper.AuthorsResponseModelMapper
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
        localDataSource: AuthorLocalDataSourse,
        mapperRemote: AuthorsResponseModelMapper,
        mapperCached: CachedAuthorsMapper

    ): AuthorRepository {
        return AuthorsRepositoryImp(networkDataSource, localDataSource, mapperRemote, mapperCached)
    }
}