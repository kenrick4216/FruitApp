package com.example.fruitapp.model

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PressureMeasurement(
    @SerialName(value = "matrix") val forceSensorReading: Float = 0.0f
) {
    /**
     * Checks if the measurement is the default value
     */
    fun isDefault(): Boolean {
        return this.forceSensorReading == 0.0f
    }

    /**
     * Returns a string representation of the measurement
     */
    @SuppressLint("DefaultLocale")
    override fun toString(): String {
        if (isDefault()) {
            return "No pressure sensor data received."
        }

        return String.format("Weight: %.2f", forceSensorReading)
    }
}
