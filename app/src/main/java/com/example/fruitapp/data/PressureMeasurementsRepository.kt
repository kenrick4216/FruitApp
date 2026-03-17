package com.example.fruitapp.data

import com.example.fruitapp.model.PressureMeasurement
import com.example.fruitapp.network.PressureMeasurementApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PressureMeasurementsRepository {
    suspend fun getMeasurements(): PressureMeasurement
}

class NetworkPressureMeasurementsRepository(
    private val pressureMeasurementApiService: PressureMeasurementApiService
) : PressureMeasurementsRepository {

    override suspend fun getMeasurements(): PressureMeasurement = withContext(Dispatchers.IO) {
        try {
            pressureMeasurementApiService.getMeasurements()
        } catch (e: Exception) {
            e.printStackTrace()
            PressureMeasurement()
        }
    }
}
