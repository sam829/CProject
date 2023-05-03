package com.saumya.practicaltaskc.domain

import android.annotation.SuppressLint
import android.util.Log
import com.saumya.practicaltaskc.BuildConfig
import com.saumya.practicaltaskc.data.source.local.dao.RandomUserDao
import com.saumya.practicaltaskc.data.source.local.entities.RandomUserCache
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import com.saumya.practicaltaskc.domain.mappers.mapRandomUser
import com.saumya.practicaltaskc.network.NetworkService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
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
    fun getRandomUser(): Observable<RandomUserResponse> {
        return Observable.create { emitter ->
            networkService.getRandomUser()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.e("error", it.toString())
                        saveRandomUserToDatabase(mapRandomUser(it))
                        emitter.onNext(it)
                    },
                    {
                        Log.e("error", it.message, it)
                        Log.e("error", "${BuildConfig.API_URL}/api/")
                    },
                    { emitter.onComplete() }
                )
        }
    }

    private fun saveRandomUserToDatabase(randomUserCache: RandomUserCache) {
        Thread { randomUserDao.insertUser(randomUserCache) }.start()
    }
}