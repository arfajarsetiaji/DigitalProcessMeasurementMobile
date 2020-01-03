package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.report

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.arfajarsetiaji.digitalprocessmeasurementmobile.DigitalProcessMeasurementMobile
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.ReportEntries
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.ReportEntryItem
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

@Suppress("UNCHECKED_CAST")
class ReportPresenter(private val reportView: ReportView) {
    var gson = Gson()
    private var gsonBuilder = GsonBuilder()

    suspend fun getAndShowReportEntryListFromServer() {
        reportView.showRefreshing()
        return withContext(Dispatchers.IO) {
            gson = gsonBuilder.create()
            AndroidNetworking.get(DigitalProcessMeasurementMobile.instance.resources.getString(R.string.api_report_url))
                .setPriority(Priority.HIGH).build().getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        val reportEntries: ReportEntries = gson.fromJson(response.toString(), ReportEntries::class.java)
                        val reportEntryItems = reportEntries.reportEntryItems
                        val reportEntryList: List<ReportEntryItem> = reportEntryItems as List<ReportEntryItem>
                        reportView.showReportEntryList(reportEntryList)
                        reportView.hideRefreshing()
                    }
                    override fun onError(anError: ANError?) { try { } catch (e: Exception) { } }
                })
        }
    }

    suspend fun queryAndShowReportEntryListFromServer(text: String) {
        reportView.showRefreshing()
        return withContext(Dispatchers.IO) {
            gson = gsonBuilder.create()
            AndroidNetworking.get(DigitalProcessMeasurementMobile.instance.resources.getString(R.string.api_report_url))
                .setPriority(Priority.HIGH).build().getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        val reportEntries: ReportEntries = gson.fromJson(response.toString(), ReportEntries::class.java)
                        val reportEntryItems = reportEntries.reportEntryItems
                        reportEntryItems?.retainAll { it.toString().contains(text)}
                        val reportEntryList: List<ReportEntryItem> = reportEntryItems as List<ReportEntryItem>
                        reportView.showReportEntryList(reportEntryList)
                        reportView.hideRefreshing()
                    }
                    override fun onError(anError: ANError?) { try { } catch (e: Exception) { } }
                })
        }
    }
}