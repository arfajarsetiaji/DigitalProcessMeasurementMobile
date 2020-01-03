package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.report

import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.ReportEntryItem

interface ReportView{
    fun showRefreshing()
    fun hideRefreshing()
    fun showReportEntryList(reportEntryItems: List<ReportEntryItem>)
}