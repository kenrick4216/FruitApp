package com.example.fruitapp.data

import android.content.Context
import android.graphics.Bitmap
import com.example.fruitapp.model.Measurement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

/**
 * Implementation of [MeasurementsRepository] that uses a Room database for persistence
 * and the local file system for image storage.
 */
class OfflineMeasurementsRepository(
    private val measurementDao: MeasurementDao,
    private val context: Context
) : MeasurementsRepository {
    
    /**
     * Returns a stream of all measurements from the database, ordered by ID.
     */
    override fun getAllMeasurementsStream(): Flow<List<Measurement>> =
        measurementDao.getAllMeasurements()

    /**
     * Returns a stream of a specific measurement by its [id].
     */
    override fun getMeasurementStream(id: Int): Flow<Measurement?> =
        measurementDao.getMeasurement(id)

    /**
     * Inserts a [measurement] into the database.
     */
    override suspend fun insertMeasurement(measurement: Measurement) =
        measurementDao.insert(measurement)

    /**
     * Deletes a [measurement] from the database.
     */
    override suspend fun deleteMeasurement(measurement: Measurement) =
        measurementDao.delete(measurement)

    /**
     * Saves a [bitmap] to the app's internal storage as a PNG file.
     * @return The absolute path to the saved file, or null if saving failed.
     */
    override suspend fun saveImageToInternalStorage(bitmap: Bitmap): String? = withContext(Dispatchers.IO) {
        val fileName = "image_${UUID.randomUUID()}.png"
        val file = File(context.filesDir, fileName)
        try {
            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            file.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Clears all measurements from the database and resets the autoincrement primary key.
     */
    override suspend fun deleteAllMeasurements() {
        measurementDao.deleteAll()
        measurementDao.resetId()
    }
}
