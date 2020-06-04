package com.example.parayo.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ParayoRepository @Inject constructor(private val parayoService: ParayoService) :
    ParayoService {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun hello(): com.example.parayo.data.model.ParayoResponse =
        withContext(ioDispatcher) {
            parayoService.hello()
        }
}