package com.saumya.practicaltaskc.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saumya.practicaltaskc.data.source.local.converters.InfoTypeConverter
import com.saumya.practicaltaskc.data.source.local.converters.ListResultTypeConverter
import com.saumya.practicaltaskc.data.source.local.dao.RandomUserDao
import com.saumya.practicaltaskc.data.source.local.entities.RandomUserCache

@Database(
    entities = [
        RandomUserCache::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(ListResultTypeConverter::class, InfoTypeConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun randomUserDao(): RandomUserDao
}