package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.data

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.arfajarsetiaji.digitalprocessmeasurementmobile.DigitalProcessMeasurementMobile
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntry
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

@Suppress("DeferredResultUnused", "DEPRECATION", "UNCHECKED_CAST")
class DataPresenter(private val dataView: DataView) {
    var gson = Gson()
    var gsonBuilder = GsonBuilder()

    suspend fun getDataEntryList() {
        dataView.showRefreshing()
        return withContext(Dispatchers.IO) {
            gson = gsonBuilder.create()
            AndroidNetworking.get(DigitalProcessMeasurementMobile.instance.resources.getString(R.string.api_data_base_url))
                .setPriority(Priority.LOW).build().getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        val dataEntries: DataEntry = gson.fromJson(response.toString(), DataEntry::class.java)
                        Log.d("TAG", dataEntries.toString())
                        //dataView.showDataEntryList(dataEntries as List<DataEntry>)
                        dataView.hideRefreshing()
                    }
                    override fun onError(anError: ANError?) {
                        try { } catch (e: Exception) { }
                    }

                })
        }
    }
}