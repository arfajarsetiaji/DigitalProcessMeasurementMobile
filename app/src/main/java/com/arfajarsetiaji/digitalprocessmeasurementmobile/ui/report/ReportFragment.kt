package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.report

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.adapter.ReportEntryAdapter
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.AppPreferences
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.ReportEntryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.onRefresh

class ReportFragment : Fragment(), ReportView {
    private var reportEntryItems: MutableList<ReportEntryItem> = mutableListOf()
    private var reportPresenter: ReportPresenter = ReportPresenter(this)
    private lateinit var spReport: Spinner
    private lateinit var srlReport: SwipeRefreshLayout
    private lateinit var rvReport : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_report, container, false)
        spReport = root.findViewById(R.id.sp_report)
        srlReport = root.findViewById(R.id.srl_report)
        rvReport = root.findViewById(R.id.rv_report)
        rvReport.layoutManager = LinearLayoutManager(act)
        rvReport.adapter = ReportEntryAdapter(reportEntryItems, act)
        spReport.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d("POSITION", position.toString())
                AppPreferences.selectedBenefitReportMenu = position.toString()
                Log.d("POSITIO", AppPreferences.selectedBenefitReportMenu.toString())
                GlobalScope.launch(Dispatchers.Main) { reportPresenter.getAndShowReportEntryListFromServer() }
            }
        }
        AppPreferences.selectedBenefitReportMenu?.toInt()?.let { spReport.setSelection(it) }
        srlReport.onRefresh { GlobalScope.launch(Dispatchers.Main) { reportPresenter.getAndShowReportEntryListFromServer() } }
        if (reportEntryItems.isEmpty()){ GlobalScope.launch(Dispatchers.Main) { reportPresenter.getAndShowReportEntryListFromServer() } }
        return root
    }

    override fun showRefreshing() { srlReport.isRefreshing = true }

    override fun hideRefreshing() { srlReport.isRefreshing = false }

    override fun showReportEntryList(reportEntryItems: List<ReportEntryItem>) {
        this.reportEntryItems.clear()
        this.reportEntryItems.addAll(reportEntryItems)
        rvReport.adapter?.notifyDataSetChanged()
    }
}