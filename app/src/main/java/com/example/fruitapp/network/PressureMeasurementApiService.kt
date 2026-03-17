package com.example.fruitapp.network

import com.example.fruitapp.model.PressureMeasurement
import retrofit2.http.GET

/**
 * Retrofit service object for creating api calls
 */
interface PressureMeasurementApiService {
    @GET("trigger")
    suspend fun getMeasurements(): PressureMeasurement
}
