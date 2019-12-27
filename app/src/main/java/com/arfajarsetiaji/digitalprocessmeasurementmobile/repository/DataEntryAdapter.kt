package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import org.w3c.dom.Text

class DataEntryAdapter(private val dataEntryItems: MutableList<DataEntryItem>,
                       private val context: Context): RecyclerView.Adapter<DataEntryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_data_entry, parent, false), context)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bindItem(
        dataEntryItems[position]) }
    override fun getItemCount(): Int = dataEntryItems.size

    class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView){
        private val tvContentJidNo: TextView = itemView.findViewById(R.id.tv_content_jid_no)
        private val tvContentStatus: TextView = itemView.findViewById(R.id.tv_content_status)
        private val tvContentDate: TextView = itemView.findViewById(R.id.tv_content_date)
        private val tvContentPartNo: TextView = itemView.findViewById(R.id.tv_content_part_no)
        private val tvContentQty: TextView = itemView.findViewById(R.id.tv_content_qty)
        private val tvContentProgram: TextView = itemView.findViewById(R.id.tv_content_program)
        private val tvContentWorkCenter: TextView = itemView.findViewById(R.id.tv_content_work_center)
        private val tvContentPackageSource: TextView = itemView.findViewById(R.id.tv_content_package_source)
        private val tvContentPackageStatus: TextView = itemView.findViewById(R.id.tv_content_package_status)
        private val tvContentIfIncomplete: TextView = itemView.findViewById(R.id.tv_content_if_incomplete)
        private val tvContentDescrepancy: TextView = itemView.findViewById(R.id.tv_content_descrepancy)
        private val tvContentRemarksSqg: TextView = itemView.findViewById(R.id.tv_content_remarks_sqg)
        private val tvContentRemarksFpy: TextView = itemView.findViewById(R.id.tv_content_remarks_fpy)

        @SuppressLint("DefaultLocale")
        fun bindItem(dataEntryItem: DataEntryItem){
            if (!dataEntryItem.jid_no.isNullOrEmpty() && dataEntryItem.jid_no != "-")tvContentJidNo.text = dataEntryItem.jid_no.capitalize()
            if (!dataEntryItem.status.isNullOrEmpty() && dataEntryItem.status != "-")tvContentStatus.text = dataEntryItem.status.toUpperCase()
            if (!dataEntryItem.date.isNullOrEmpty() && dataEntryItem.date != "-")tvContentDate.text = dataEntryItem.date.substring(0,9).capitalize()
            if (!dataEntryItem.part_no.isNullOrEmpty() && dataEntryItem.part_no != "-")tvContentPartNo.text = dataEntryItem.part_no.capitalize()
            if (!dataEntryItem.qty.isNullOrEmpty() && dataEntryItem.qty != "-")tvContentQty.text = dataEntryItem.qty.capitalize()
            if (!dataEntryItem.program.isNullOrEmpty() && dataEntryItem.program != "-")tvContentProgram.text = dataEntryItem.program.capitalize()
            if (!dataEntryItem.work_center.isNullOrEmpty() && dataEntryItem.work_center != "-")tvContentWorkCenter.text = dataEntryItem.work_center.capitalize()
            if (!dataEntryItem.package_source.isNullOrEmpty() && dataEntryItem.package_source != "-")tvContentPackageSource.text = dataEntryItem.package_source.capitalize()
            if (!dataEntryItem.package_status.isNullOrEmpty() && dataEntryItem.package_status != "-")tvContentPackageStatus.text = dataEntryItem.package_status.capitalize()
            if (!dataEntryItem.package_if_incomplete.isNullOrEmpty() && dataEntryItem.package_if_incomplete != "-")tvContentIfIncomplete.text = dataEntryItem.package_if_incomplete.capitalize()
            if (!dataEntryItem.descrepancy.isNullOrEmpty() && dataEntryItem.descrepancy != "-")tvContentDescrepancy.text = dataEntryItem.descrepancy.capitalize()
            if (!dataEntryItem.remarks_sqg.isNullOrEmpty() && dataEntryItem.remarks_sqg != "-")tvContentRemarksSqg.text = dataEntryItem.remarks_sqg.capitalize()
            if (!dataEntryItem.remarks_fpy.isNullOrEmpty() && dataEntryItem.remarks_fpy != "-")tvContentRemarksFpy.text = dataEntryItem.remarks_fpy.capitalize()

            /*itemView.onClick {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra("MOVIE_ITEM", movieItem)
                context.startActivity(intent)
            }*/
        }
    }
}