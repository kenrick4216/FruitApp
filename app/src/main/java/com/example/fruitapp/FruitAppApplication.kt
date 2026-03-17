package com.example.fruitapp;

import android.app.Application
import com.example.fruitapp.data.AppContainer
import com.example.fruitapp.data.DefaultAppContainer

/**
 * Custom Application class for the FruitApp.
 * Responsible for initializing the dependency injection container.
 */
class FruitAppApplication : Application() {
    /**
     * AppContainer instance used by the rest of the classes to obtain dependencies.
     */
    lateinit var container: AppContainer

    /**
     * Called when the application is starting, before any activity, service, or receiver objects (excluding content providers) have been created.
     */
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}
