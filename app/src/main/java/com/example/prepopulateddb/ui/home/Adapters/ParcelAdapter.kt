package com.example.prepopulateddb.ui.home.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prepopulateddb.Models.Parcel
import com.example.prepopulateddb.databinding.ParcelRowLayoutBinding

class ParcelAdapter(var parcelList: MutableList<Parcel>) : RecyclerView.Adapter<ParcelAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ParcelRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(parcelList[position]) {
                binding.dateTime.text = this.date_time.toString()
                binding.eventId.text= this.event_id.toString()
                binding.trackingNum.text = this.tracking_num.toString()
                binding.status.text = this.status
                binding.location.text = this.location
            }
        }
    }

    override fun getItemCount(): Int {
        return parcelList.size
    }



    inner class ViewHolder(val binding: ParcelRowLayoutBinding) :
            RecyclerView.ViewHolder(binding.root)
}