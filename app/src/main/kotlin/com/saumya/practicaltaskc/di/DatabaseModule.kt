package com.saumya.practicaltaskc.di

import android.content.Context
import androidx.room.Room
import com.saumya.practicaltaskc.data.source.local.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module for local database access [Database], and other dao direct access [RandomUserDao]
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context): Database =
        Room.databaseBuilder(appContext, Database::class.java, "database").build()

    @Provides
    @Singleton
    fun providesRandomUserDao(database: Database) = database.randomUserDao()
}