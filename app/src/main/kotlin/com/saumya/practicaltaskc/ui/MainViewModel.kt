package com.saumya.practicaltaskc.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import com.saumya.practicaltaskc.domain.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for handling business logic from UI layer
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _randomUser = MutableStateFlow<RandomUserResponse?>(null)
    val randomUser: StateFlow<RandomUserResponse?>
        get() = _randomUser.asStateFlow()

    private fun getRandomUser() {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getRandomUser().collectLatest { randomUser ->
                _randomUser.update { randomUser }
            }
        }
    }

    fun refreshData() {
        viewModelScope.launch(Dispatchers.IO) {
            _randomUser.update { null }
            mainRepository.clearDataFromLocal()
            getRandomUser()
        }
    }

    init {
        getRandomUser()
    }
}