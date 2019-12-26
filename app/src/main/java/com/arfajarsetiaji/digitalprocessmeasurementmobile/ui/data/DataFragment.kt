package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntryAdapter
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntry
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.onRefresh

class DataFragment : Fragment(), DataView {
    private var dataEntries: MutableList<DataEntry> = mutableListOf()
    private var dataPresenter: DataPresenter = DataPresenter(this)
    private lateinit var srlData: SwipeRefreshLayout
    private lateinit var rvData : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_data, container, false)
        srlData = root.findViewById(R.id.srl_data)
        rvData = root.findViewById(R.id.rv_data)
        srlData.onRefresh { GlobalScope.launch(Dispatchers.Main) { dataPresenter.getDataEntryList() } }
        /*val dataEntry = DataEntry(1, 1234567890,"1234567890", "N/A", "N/A", "01-01-2001","N/A","N/A", "N/A",
            10, "No Pass", "-", "-", "-")*/
        //dataEntries.add(0,dataEntry)
        rvData.layoutManager = LinearLayoutManager(act)
        rvData.adapter = DataEntryAdapter(dataEntries, act)
        if (dataEntries.isEmpty()){ GlobalScope.launch(Dispatchers.Main) {dataPresenter.getDataEntryList() } }
        return root
    }

    override fun showRefreshing() {
        srlData.isRefreshing = true
    }

    override fun hideRefreshing() {
        srlData.isRefreshing = false
    }

    override fun showDataEntryList(dataEntries: List<DataEntry>) {
        this.dataEntries.clear()
        this.dataEntries.addAll(dataEntries)
        rvData.adapter?.notifyDataSetChanged()
    }
}