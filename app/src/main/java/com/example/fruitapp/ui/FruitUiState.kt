package com.example.fruitapp.ui

import com.example.fruitapp.data.Measurement

/**
 * UI state for the Fruit App
 */
data class FruitUiState (
    val measurement: Measurement = Measurement(
        0,
        0.0f,
        0.0f,
        "",
        "",
        listOf(),
        0.0f,
        0,
        0,
        0,
        0,
        0
    ),
    val measurements: List<Measurement> = listOf()
)