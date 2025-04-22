package org.sopt.at

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AtSoptApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}