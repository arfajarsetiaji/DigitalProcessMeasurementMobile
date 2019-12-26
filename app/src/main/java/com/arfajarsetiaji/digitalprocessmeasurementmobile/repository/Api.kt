package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository

import retrofit2.Call
import retrofit2.http.GET


interface Api {
    @get:GET("data_sqg_fpy.json")
    val heroes: Call<List<DataEntry?>?>?

    companion object {
        const val BASE_URL = "https://arfajarsetiaji.github.io/digitalmeasurementmobile"
    }
}