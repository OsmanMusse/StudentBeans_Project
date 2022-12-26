package com.example.sbtechincaltest.di

import com.example.sbtechincaltest.data.remote.PhotoApi
import com.example.sbtechincaltest.data.repository.PhotoItemRepository_Impl
import com.example.sbtechincaltest.domain.repository.PhotoItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePhotoListApi(): PhotoApi {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providePhotoItemRepository(api: PhotoApi): PhotoItemRepository {
        return PhotoItemRepository_Impl(api)
    }
}