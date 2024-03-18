package com.example.bookappcompose.di


import com.example.data.book.cache.db.BooksDao
import com.example.data.book.cache.mapper.CachedBookMapper
import com.example.data.book.data.repository.BooksRepositoryImp
import com.example.data.book.data.store.BookLocalDataSource
import com.example.data.book.data.store.BookNetworkDataSource
import com.example.data.book.remote.mapper.BookResponseModelMapper
import com.example.data.book.remote.service.BooksServices
import com.example.domain.books.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BookRepositoryModule {

    @Provides
    fun provideBookNetworkDataSource(apiService: BooksServices): BookNetworkDataSource {
        return BookNetworkDataSource(apiService)
    }

    @Provides
    fun provideBookLocalDataSource(dao: BooksDao): BookLocalDataSource {
        return BookLocalDataSource(dao)
    }

    @Provides
    fun provideCachedBookMapper(): CachedBookMapper {
        return CachedBookMapper
    }


    @Provides
    fun provideBookBookMapper(): BookResponseModelMapper {
        return BookResponseModelMapper
    }


    @Provides
    fun provideBookRepository(
        networkDataSource: BookNetworkDataSource,
        localDataSource: BookLocalDataSource,
        mapperRemote: BookResponseModelMapper,
        mapperCached: CachedBookMapper

    ): BooksRepository {
        return BooksRepositoryImp(networkDataSource, localDataSource, mapperRemote, mapperCached)
    }
}