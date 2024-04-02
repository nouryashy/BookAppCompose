package com.example.bookappcompose.di

import android.app.Application
import androidx.room.Room
import com.example.data.book.cache.db.BooksDatabase
import com.example.bookappcompose.utils.Constants
import com.example.data.author.cache.db.AuthorsDao
import com.example.data.author.cache.db.AuthorsDatabase
import com.example.data.author.remote.AuthorsServices
import com.example.data.book.cache.db.BooksDao
import com.example.data.book.remote.service.BooksServices
import com.example.data.category.categoryBooks.cached.db.CategoryBooksDao
import com.example.data.category.categoryBooks.cached.db.CategoryBooksDataBase
import com.example.data.category.categoryBooks.remote.services.CategoryBooksServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    fun provideBookApiService(retrofit: Retrofit): BooksServices {
        return retrofit.create(BooksServices::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthorApiService(retrofit: Retrofit): AuthorsServices {
        return retrofit.create(AuthorsServices::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryBooksApiService(retrofit: Retrofit): CategoryBooksServices {
        return retrofit.create(CategoryBooksServices::class.java)
    }


    @Provides
    @Singleton
    fun provideBookDatabase(app: Application): BooksDatabase {
        return Room.databaseBuilder(app, BooksDatabase::class.java, "books_database")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthorDatabase(app: Application): AuthorsDatabase {
        return Room.databaseBuilder(app, AuthorsDatabase::class.java, "authors_database")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryBookDatabase(app: Application): CategoryBooksDataBase {
        return Room.databaseBuilder(app, CategoryBooksDataBase::class.java, "categories_database")
            .allowMainThreadQueries()
            .build()
    }




    @Provides
    @Singleton
    fun provideBookDao(database: BooksDatabase): BooksDao {
        return database.BooksDao()
    }

    @Provides
    @Singleton
    fun provideAuthorDao(database: AuthorsDatabase): AuthorsDao {
        return database.authorDao()
    }


    @Provides
    @Singleton
    fun provideCategoryBookDao(database: CategoryBooksDataBase): CategoryBooksDao {
        return database.categoryBooksDao()
    }



}