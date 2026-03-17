package com.example.fruitapp.model

import android.graphics.Bitmap
import androidx.room.Ignore

/**
 * Data class to represent the image received from the ESP32 CAM.
 * Room will only persist the filePath.
 */
data class Image(
    val filePath: String? = null
) {
    /**
     * Checks if the image is the default value
     */
    fun isDefault(): Boolean {
        return this.filePath == null
    }

    @Ignore
    var bitmap: Bitmap? = null

    /**
     * Secondary constructor for creating an Image from a Bitmap.
     * This is used when the image is first fetched from the network.
     */
    @Ignore
    constructor(bitmap: Bitmap) : this(null) {
        this.bitmap = bitmap
    }

    /**
     * Parameterless constructor for Room or other frameworks.
     */
    @Ignore
    constructor() : this(null)
}
