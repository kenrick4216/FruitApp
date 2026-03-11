package com.example.fruitapp.data

import com.example.fruitapp.model.ReganMeasurement
import com.example.fruitapp.network.ReganMeasurementApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ReganMeasurementsRepository {
    suspend fun getMeasurements(): ReganMeasurement
}

class NetworkReganMeasurementsRepository(
    private val reganMeasurementApiService: ReganMeasurementApiService
) : ReganMeasurementsRepository {

    override suspend fun getMeasurements(): ReganMeasurement = withContext(Dispatchers.IO) {
        try {
            reganMeasurementApiService.getMeasurements()
        } catch (e: Exception) {
            e.printStackTrace()
            ReganMeasurement()
        }
    }
}
