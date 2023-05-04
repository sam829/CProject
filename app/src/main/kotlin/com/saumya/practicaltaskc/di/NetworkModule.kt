package com.saumya.practicaltaskc.di

import com.saumya.practicaltaskc.BuildConfig
import com.saumya.practicaltaskc.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * This module helps with providing retrofit builder [Retrofit] and NetworkService instance [NetworkService]
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): NetworkService = retrofit.create()
}