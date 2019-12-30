package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.data

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.arfajarsetiaji.digitalprocessmeasurementmobile.DigitalProcessMeasurementMobile
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntries
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntryItem
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
            AndroidNetworking.get(DigitalProcessMeasurementMobile.instance.resources.getString(R.string.api_data_url))
                .setPriority(Priority.LOW).build().getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        val dataEntries: DataEntries? = gson.fromJson(response.toString(), DataEntries::class.java)
                        val dataEntryItems: List<DataEntryItem> = dataEntries?.dataEntryItems as List<DataEntryItem>
                        Log.d("TAG", dataEntries.toString())
                        dataView.showDataEntryList(dataEntryItems)
                        dataView.hideRefreshing()
                    }
                    override fun onError(anError: ANError?) {
                        try { } catch (e: Exception) { }
                    }
                })
        }
    }
}