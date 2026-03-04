package com.example.fruitapp.ui

import androidx.lifecycle.ViewModel
import com.example.fruitapp.R
import com.example.fruitapp.data.Measurement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

/**
 * View Model for the Fruit App
 */
class FruitViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(FruitUiState())
    val uiState: StateFlow<FruitUiState> = _uiState.asStateFlow()

    /**
     * Generates a new measurement with dummy data. For testing purposes only
     *
     * This will be replaced by real data from the ESP32 via WiFi transmission or the like
     */
    fun generateRandomMeasurement() {
        val measurement = Measurement(
                R.drawable.banana,
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextInt().toString(),
                Random.nextInt().toString(),
                listOf(Random.nextFloat(), Random.nextFloat(), Random.nextFloat()),
                Random.nextFloat(),
                Random.nextInt(),
                Random.nextInt(),
                Random.nextInt(),
                Random.nextInt(),
                Random.nextInt()
        )

        _uiState.update { currentState ->
            currentState.copy(measurement = measurement)
        }
    }

    /**
     * Adds the current new measurement to the list of measurements
     */
    fun addMeasurement(measurement: Measurement) {
        _uiState.update { currentState ->
            currentState.copy(
                measurements = currentState.measurements + measurement
            )
        }
    }
}
