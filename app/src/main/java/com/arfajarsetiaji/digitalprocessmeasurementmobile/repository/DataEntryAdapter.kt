package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R

class DataEntryAdapter(private val dataEntryItems: MutableList<DataEntry>,
                       private val context: Context): RecyclerView.Adapter<DataEntryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_data_entry, parent, false), context)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bindItem(dataEntryItems[position]) }
    override fun getItemCount(): Int = dataEntryItems.size

    class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView){
        private val tvContentJidNo: TextView = itemView.findViewById(R.id.tv_content_jid_no)
        private val tvContentPartNo: TextView = itemView.findViewById(R.id.tv_content_part_no)
        private val tvContentQty: TextView = itemView.findViewById(R.id.tv_content_qty)
        private val tvContentProgram: TextView = itemView.findViewById(R.id.tv_content_program)
        private val tvContentWorkCenter: TextView = itemView.findViewById(R.id.tv_content_work_center)
        private val tvContentDate: TextView = itemView.findViewById(R.id.tv_content_date)

        fun bindItem(dataEntry: DataEntry){
            tvContentJidNo.text = dataEntry.jid_no.toString()
            tvContentPartNo.text = dataEntry.part_no
            tvContentProgram.text = dataEntry.program
            tvContentWorkCenter.text = dataEntry.work_center
            tvContentDate.text = dataEntry.date
            tvContentQty.text = dataEntry.qty.toString()


            /*itemView.onClick {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra("MOVIE_ITEM", movieItem)
                context.startActivity(intent)
            }*/
        }
    }
}