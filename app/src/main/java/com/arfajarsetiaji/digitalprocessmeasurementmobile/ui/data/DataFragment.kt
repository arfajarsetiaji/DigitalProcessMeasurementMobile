package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.data

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntryAdapter
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.DataEntryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.onRefresh


class DataFragment : Fragment(), DataView {
    private var dataEntryItems: MutableList<DataEntryItem> = mutableListOf()
    private var dataPresenter: DataPresenter = DataPresenter(this)
    private lateinit var srlData: SwipeRefreshLayout
    private lateinit var rvData : RecyclerView
    private lateinit var svData: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_data, container, false)
        srlData = root.findViewById(R.id.srl_data)
        rvData = root.findViewById(R.id.rv_data)
        rvData.layoutManager = LinearLayoutManager(act)
        rvData.adapter = DataEntryAdapter(dataEntryItems, act)
        srlData.onRefresh {
            if (!svData.isIconified){
                GlobalScope.launch(Dispatchers.Main) { dataPresenter.queryAndShowDataEntryListFromServer(svData.query.toString()) }
            } else {
                GlobalScope.launch(Dispatchers.Main) { dataPresenter.getAndShowDataEntryListFromServer() } }
        }
        if (dataEntryItems.isEmpty()){ GlobalScope.launch(Dispatchers.Main) { dataPresenter.getAndShowDataEntryListFromServer() } }
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.fragment_data, menu)
        val svDataItem = menu.findItem(R.id.action_search)
        svData = svDataItem.actionView as SearchView
        svData.queryHint = "Search"
        svData.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                GlobalScope.launch(Dispatchers.Main) { query?.let { dataPresenter.queryAndShowDataEntryListFromServer(it) } }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                GlobalScope.launch(Dispatchers.Main) { newText?.let { dataPresenter.queryAndShowDataEntryListFromServer(it) } }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun showRefreshing() { srlData.isRefreshing = true }

    override fun hideRefreshing() { srlData.isRefreshing = false }

    override fun showDataEntryList(dataEntryItems: List<DataEntryItem>) {
        this.dataEntryItems.clear()
        this.dataEntryItems.addAll(dataEntryItems)
        rvData.adapter?.notifyDataSetChanged()
    }
}