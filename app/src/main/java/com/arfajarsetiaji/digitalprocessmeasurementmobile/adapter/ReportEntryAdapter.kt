package com.arfajarsetiaji.digitalprocessmeasurementmobile.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.ReportEntryItem

class ReportEntryAdapter(private val reportEntryItems: MutableList<ReportEntryItem>, private val context: Context): RecyclerView.Adapter<ReportEntryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_report_entry, parent, false), context)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bindItem(reportEntryItems[position]) }

    override fun getItemCount(): Int = reportEntryItems.size

    class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView){
        private val tvContentMonth: TextView = itemView.findViewById(R.id.tv_content_month)
        private val tvContentRate: TextView = itemView.findViewById(R.id.tv_content_rate)
        private val tvContentIndex: TextView = itemView.findViewById(R.id.tv_content_index)
        private val tvContentBenefit: TextView = itemView.findViewById(R.id.tv_content_benefit)

        @SuppressLint("DefaultLocale")
        fun bindItem(reportEntryItem: ReportEntryItem){
            tvContentMonth.text = reportEntryItem.month.toString()
            tvContentRate.text = reportEntryItem.rate.toString()
            tvContentIndex.text = reportEntryItem.index.toString()
            tvContentBenefit.text = reportEntryItem.benefit.toString()
        }
    }
}