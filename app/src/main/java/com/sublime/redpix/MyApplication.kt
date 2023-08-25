package com.sublime.redpix

import android.app.Application
import timber.log.Timber

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        setupLogger()
    }

    private fun setupLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}