package com.example.parayo.repository

import com.example.parayo.repository.model.ParayoResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ParayoRepository @Inject constructor(private val parayoService: ParayoService) :
    ParayoService {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun hello(): ParayoResponse = withContext(ioDispatcher) {
        parayoService.hello()
    }
}