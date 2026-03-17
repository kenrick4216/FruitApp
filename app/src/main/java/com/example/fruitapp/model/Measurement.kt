package com.example.fruitapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "measurements")
data class Measurement(
    @Embedded val esp32Measurement: Esp32Measurement,
    @Embedded val pressureMeasurement: PressureMeasurement,
    @Embedded val image: Image,
    val prediction: String = "No Prediction",
    val date: LocalDateTime = LocalDateTime.now(),
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {
    /**
     * Checks if the measurement is the default value
     */
    fun isDefault(): Boolean {
        return esp32Measurement.isDefault() &&
                pressureMeasurement.isDefault() &&
                image.isDefault()
    }

    /**
     * Returns a string representation of the measurement
     */
    override fun toString(): String {
        if (isDefault()) {
            return "No Measurement Received."
        }
        return "$esp32Measurement\n$pressureMeasurement"
    }
}
