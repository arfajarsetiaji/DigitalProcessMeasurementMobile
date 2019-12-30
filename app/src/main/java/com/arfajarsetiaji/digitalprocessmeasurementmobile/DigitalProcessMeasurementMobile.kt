package com.arfajarsetiaji.digitalprocessmeasurementmobile

import android.app.Application
import com.androidnetworking.AndroidNetworking

class DigitalProcessMeasurementMobile : Application() {
    companion object { lateinit var instance: DigitalProcessMeasurementMobile private set }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AndroidNetworking.initialize(this)
    }
}