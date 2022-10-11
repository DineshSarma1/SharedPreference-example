package com.example.daggerhiltmvvmpractice2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltmvvmpractice2.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    private val _data: MutableLiveData<String> = MutableLiveData()
    val data: LiveData<String> = _data

    //binding input field from layout into this parameter
    var userInput = MutableLiveData<String>()

    init {
        loadRecord()
    }

    fun getUserName(): LiveData<String> {
        return data
    }

    fun insertUserName() {
        viewModelScope.launch {
            repository.insertUserData(userInput.value!!)
            loadRecord()
        }
    }

    private fun loadRecord() {
        viewModelScope.launch {
            _data.postValue(repository.getUserData())
        }
    }

}