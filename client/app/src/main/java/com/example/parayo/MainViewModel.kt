package com.example.parayo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parayo.repository.ParayoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val parayoRepository: ParayoRepository
) : ViewModel() {

    private val _hello = MutableLiveData<String>()
    val hello: LiveData<String> get() = _hello

    fun getHello() = viewModelScope.launch {
        _hello.value = parayoRepository.hello().data ?: ""
    }
}