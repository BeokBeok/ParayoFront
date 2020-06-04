package com.example.parayo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parayo.data.ParayoRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val parayoRepository: ParayoRepository
) : ViewModel() {

    private val _hello = MutableLiveData<String>()
    val hello: LiveData<String> get() = _hello

    fun getHello() = viewModelScope.launch {
        _hello.value = parayoRepository.getHello().data ?: ""
    }
}