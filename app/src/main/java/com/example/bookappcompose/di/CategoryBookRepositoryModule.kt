package com.example.bookappcompose.di

import com.example.data.category.categoryBooks.cached.db.CategoryBooksDao
import com.example.data.category.categoryBooks.cached.mapper.CachedCategoryBookMapper
import com.example.data.category.categoryBooks.data.repository.CategoryBooksRepositoryImp
import com.example.data.category.categoryBooks.data.store.CategoryBooksLocalDataSource
import com.example.data.category.categoryBooks.data.store.CategoryBooksNetworkDataSource
import com.example.data.category.categoryBooks.remote.mapper.CategoryBookResponseModelMapper
import com.example.data.category.categoryBooks.remote.services.CategoryBooksServices
import com.example.domain.category.categorybooks.repository.CategoryBooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryBookRepositoryModule {
    @Provides
    fun provideCatBookNetworkDataSource(apiService: CategoryBooksServices): CategoryBooksNetworkDataSource {
        return CategoryBooksNetworkDataSource(apiService)
    }

    @Provides
    fun provideCatBookLocalDataSource(dao: CategoryBooksDao): CategoryBooksLocalDataSource {
        return CategoryBooksLocalDataSource(dao)
    }

    @Provides
    fun provideCatCachedBookMapper(): CachedCategoryBookMapper {
        return CachedCategoryBookMapper
    }
    @Provides
    fun provideCatBookBookMapper(): CategoryBookResponseModelMapper {
        return CategoryBookResponseModelMapper
    }
    @Provides
    fun provideBookCategoryRepository(
        networkDataSource: CategoryBooksNetworkDataSource,
        localDataSource: CategoryBooksLocalDataSource,
        mapperRemote: CategoryBookResponseModelMapper,
        mapperCached: CachedCategoryBookMapper
    ): CategoryBooksRepository {
        return CategoryBooksRepositoryImp(networkDataSource, localDataSource, mapperRemote, mapperCached)
    }
}