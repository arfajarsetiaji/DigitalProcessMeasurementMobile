package com.arfajarsetiaji.android.moviecatalogue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arfajarsetiaji.android.moviecatalogue.api.database.DataEntryItem
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R

class DataEntryAdapter(private val dataEntryItems: MutableList<DataEntryItem>,
                       private val context: Context): RecyclerView.Adapter<DataEntryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_data_entry, parent, false), context)
    //override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bindItem(dataEntryItems[position]) }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bindItem(dataEntryItems[0]) }
    //override fun getItemCount(): Int = dataEntryItems.size
    override fun getItemCount(): Int = 1000

    class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView){
        private val tvContentJidNo: TextView = itemView.findViewById(R.id.tv_content_jid_no)
        private val tvContentPartNo: TextView = itemView.findViewById(R.id.tv_content_part_no)
        private val tvContentQty: TextView = itemView.findViewById(R.id.tv_content_qty)
        private val tvContentProgram: TextView = itemView.findViewById(R.id.tv_content_program)
        private val tvContentWorkCenter: TextView = itemView.findViewById(R.id.tv_content_work_center)
        private val tvContentDate: TextView = itemView.findViewById(R.id.tv_content_date)

        fun bindItem(dataEntryItem: DataEntryItem){
            tvContentJidNo.text = dataEntryItem.jidNo
            tvContentPartNo.text = dataEntryItem.partNo
            tvContentQty.text = dataEntryItem.qty.toString()
            tvContentProgram.text = dataEntryItem.program
            tvContentWorkCenter.text = dataEntryItem.workCenter
            tvContentDate.text = dataEntryItem.date

            /*itemView.onClick {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra("MOVIE_ITEM", movieItem)
                context.startActivity(intent)
            }*/
        }
    }
}