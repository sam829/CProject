package com.saumya.practicaltaskc.ui

import androidx.lifecycle.ViewModel
import com.saumya.practicaltaskc.data.source.remote.response.random_user.InfoResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import com.saumya.practicaltaskc.domain.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * ViewModel class for handling business logic from UI layer
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    val randomUser: BehaviorSubject<RandomUserResponse> = BehaviorSubject.create()
    private fun getRandomUser() {
        mainRepository.getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(randomUser)
    }

    fun refreshData() {
        randomUser.onNext(RandomUserResponse(
            InfoResponse(0, 0, "", ""),
            emptyList()
        ))
        mainRepository.clearDataFromLocal()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(randomUser)
    }

    init {
        getRandomUser()
    }
}