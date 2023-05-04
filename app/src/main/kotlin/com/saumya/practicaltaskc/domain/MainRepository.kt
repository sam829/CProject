package com.saumya.practicaltaskc.domain

import android.annotation.SuppressLint
import android.util.Log
import com.saumya.practicaltaskc.BuildConfig
import com.saumya.practicaltaskc.data.source.local.dao.RandomUserDao
import com.saumya.practicaltaskc.data.source.local.entities.RandomUserCache
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import com.saumya.practicaltaskc.domain.mappers.mapRandomUserToCache
import com.saumya.practicaltaskc.domain.mappers.mapRandomUserToResponse
import com.saumya.practicaltaskc.network.NetworkService
import com.saumya.practicaltaskc.network.safeNetworkCall
import com.saumya.practicaltaskc.network.suspendOnFailure
import com.saumya.practicaltaskc.network.suspendOnSuccess
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository class as a Domain layer for making a single source of truth for local and remote data source
 */
@Singleton
class MainRepository @Inject constructor(
    private val networkService: NetworkService,
    private val randomUserDao: RandomUserDao
) {
    /**
     * Fetches [RandomUserResponse] and maps it to [RandomUserCache] and stores it to local database
     */
    @SuppressLint("CheckResult")
    suspend fun getRandomUser() = flow {
        val randomUser = randomUserDao.getUser()
        if (randomUser != null) {
            emit(mapRandomUserToResponse(randomUser))
        } else {
            safeNetworkCall { networkService.getRandomUser() }
                .suspendOnSuccess {
                    Log.e("error", "$data")
                    saveRandomUserToDatabase(mapRandomUserToCache(data))
                    emit(data)
                }
                .suspendOnFailure {
                    Log.e("error", "$message")
                    Log.e("error", "${BuildConfig.API_URL}/api/")
                }
        }
    }

    suspend fun clearDataFromLocal() {
        randomUserDao.clearAllUsers()
    }

    private suspend fun saveRandomUserToDatabase(randomUserCache: RandomUserCache) {
        randomUserDao.insertUser(randomUserCache)
    }
}