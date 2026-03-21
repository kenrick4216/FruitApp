package com.example.fruitapp.ui

import com.example.fruitapp.model.LidarScan
import com.example.fruitapp.model.Measurement

/**
 * UI state for the Fruit App
 */
sealed interface FruitUiState {
    data class Success(
        val measurement: Measurement
    ) : FruitUiState
    object Error : FruitUiState
    object Loading : FruitUiState
}

/**
 * UI state for the Lidar Scan
 */
sealed interface LidarUiState {
    data class Success(val lidarScan: LidarScan) : LidarUiState
    object Error : LidarUiState
    object Loading : LidarUiState
    object Idle : LidarUiState  // default state before scan is triggered
}
