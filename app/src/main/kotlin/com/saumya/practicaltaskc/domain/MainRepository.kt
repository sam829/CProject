package com.saumya.practicaltaskc.domain

import com.saumya.practicaltaskc.network.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val networkService: NetworkService
) {
}