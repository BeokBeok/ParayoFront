package com.example.parayo.data

import com.example.parayo.data.model.ParayoResponse
import com.example.parayo.data.source.ParayoDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ParayoRepository @Inject constructor(private val parayoService: ParayoService) :
    ParayoDataSource {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getHello(): ParayoResponse =
        withContext(ioDispatcher) {
            parayoService.hello()
        }
}