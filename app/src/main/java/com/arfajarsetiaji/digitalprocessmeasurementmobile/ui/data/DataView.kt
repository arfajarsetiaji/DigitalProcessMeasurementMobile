package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.data

import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntry

interface DataView{
    fun showRefreshing()
    fun hideRefreshing()
    fun showDataEntryList(dataEntries: List<DataEntry>)
}