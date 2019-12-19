package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arfajarsetiaji.android.moviecatalogue.adapter.DataEntryAdapter
import com.arfajarsetiaji.android.moviecatalogue.api.database.DataEntryItem
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import org.jetbrains.anko.support.v4.act

class DataFragment : Fragment() {
    private var dataEntryItems: MutableList<DataEntryItem> = mutableListOf()
    private lateinit var dataViewModel: DataViewModel
    private lateinit var srlData: SwipeRefreshLayout
    private lateinit var rvData : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_data, container, false)
        srlData = root.findViewById(R.id.srl_data)
        rvData = root.findViewById(R.id.rv_data)
        rvData.layoutManager = LinearLayoutManager(act)
        val dataEntryItem: DataEntryItem = DataEntryItem("12345678", "12345678", 0, "N / A", "N / A", "N / A",
            "-", "Complete  / Incomplete", "-", "Pass / No Pass", "-", "-", "-")
        dataEntryItems.add(0,dataEntryItem)
        rvData.adapter = DataEntryAdapter(dataEntryItems, act)
        return root
    }
}