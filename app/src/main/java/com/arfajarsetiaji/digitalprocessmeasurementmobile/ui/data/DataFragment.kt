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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_data, container, false)
        srlData = root.findViewById(R.id.srl_data)
        rvData = root.findViewById(R.id.rv_data)
        srlData.onRefresh { GlobalScope.launch(Dispatchers.Main) { dataPresenter.getAndShowDataEntryListFromServer() } }
        rvData.layoutManager = LinearLayoutManager(act)
        rvData.adapter = DataEntryAdapter(dataEntryItems, act)
        if (dataEntryItems.isEmpty()){ GlobalScope.launch(Dispatchers.Main) { dataPresenter.getAndShowDataEntryListFromServer() } }
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.fragment_data, menu)
        val mSearch = menu.findItem(R.id.action_search)
        val mSearchView: SearchView = mSearch.actionView as SearchView
        mSearchView.queryHint = "Search"
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (dataEntryItems.isEmpty()){
                    GlobalScope.launch(Dispatchers.Main) { dataPresenter.getAndShowDataEntryListFromServer() }
                } else {
                    dataPresenter
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun showRefreshing() {
        srlData.isRefreshing = true
    }

    override fun hideRefreshing() {
        srlData.isRefreshing = false
    }

    override fun showDataEntryList(dataEntryItems: List<DataEntryItem>) {
        this.dataEntryItems.clear()
        this.dataEntryItems.addAll(dataEntryItems)
        rvData.adapter?.notifyDataSetChanged()
    }
}