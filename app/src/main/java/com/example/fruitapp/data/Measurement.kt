package com.example.fruitapp.data

import android.icu.util.Measure
import androidx.annotation.DrawableRes
import com.example.fruitapp.R
import kotlin.random.Random


/**
 * Data class to represent the measurement from sensors
 */
data class Measurement(
    @DrawableRes val fruitImageResourceId: Int = R.drawable.banana,
    val forceSensorReading: Float = 0.0f,
    val fluorescenceReading: Float = 0.0f,
    val date: String = "",
    val time: String = "",
    val nirReadings: List<Float> = listOf(),
    val lidarReading: Float = 0.0f,
    val ethyleneConcentration: Int = 0,
    val airQuality: Int = 0,
    val mq3Reading: Int = 0,
    val mq4Reading: Int = 0,
    val mq5Reading: Int = 0
) {

    //TODO: fix override method to something nicer
    /**
     * Returns a string representation of the measurement
     */
    override fun toString(): String {
        return String.format("Fluorescence: %s\nForce Sensor Reading: %s\nNIR Readings: %s\nLidar Reading: %s\nEthylene Concentration: %s\nAir Quality: %s\nMQ3 Reading: %s\nMQ4 Reading: %s\nMQ5 Reading: %s",
            fluorescenceReading,
            forceSensorReading,
            nirReadings,
            lidarReading,
            ethyleneConcentration,
            airQuality,
            mq3Reading,
            mq4Reading,
            mq5Reading
            )
    }
}
