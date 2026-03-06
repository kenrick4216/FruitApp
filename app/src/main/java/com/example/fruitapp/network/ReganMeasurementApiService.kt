package com.example.fruitapp.network

import com.example.fruitapp.model.ReganMeasurement
import retrofit2.http.GET

/**
 * Retrofit service object for creating api calls
 */
interface ReganMeasurementApiService {
    @GET("trigger")
    suspend fun getMeasurements(): ReganMeasurement
}
