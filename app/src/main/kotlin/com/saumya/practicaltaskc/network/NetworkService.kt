package com.saumya.practicaltaskc.network

import com.saumya.practicaltaskc.data.source.remote.response.RandomUser
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface NetworkService {
    @GET("/api")
    fun getRandomUser() : Observable<RandomUser>
}