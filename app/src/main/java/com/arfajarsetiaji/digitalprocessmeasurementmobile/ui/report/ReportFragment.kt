package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R

class ReportFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_report, container, false)
        return root
    }
}