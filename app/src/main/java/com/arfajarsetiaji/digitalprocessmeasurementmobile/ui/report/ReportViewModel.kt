package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.report

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReportViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply { value = "No report" }
    val text: LiveData<String> = _text
}