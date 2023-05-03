package com.saumya.practicaltaskc.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.saumya.practicaltaskc.data.source.local.entities.RandomUserCache
import io.reactivex.rxjava3.core.Observable

@Dao
interface RandomUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(randomUserCache: RandomUserCache)

    @Update
    fun updateUser(randomUserCache: RandomUserCache)

    @Delete
    fun deleteUser(randomUserCache: RandomUserCache)

    @Query("SELECT * FROM random_user")
    fun getUser(): Observable<RandomUserCache>

    @Query("DELETE FROM random_user")
    fun clearAllUsers()
}