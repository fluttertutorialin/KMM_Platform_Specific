package org.example.project

import android.app.Application
import di.initKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}