package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.report

import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntryItem

interface DataView{
    fun showRefreshing()
    fun hideRefreshing()
    fun showDataEntryList(dataEntryItems: List<DataEntryItem>)
}