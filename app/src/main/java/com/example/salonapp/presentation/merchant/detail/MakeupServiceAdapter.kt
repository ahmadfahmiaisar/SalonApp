package com.example.salonapp.presentation.merchant.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.salonapp.databinding.ItemMakeupServiceBinding
import com.example.salonapp.domain.entity.merchant.MakeupMerchantDetail

class MakeupServiceAdapter(var makeupServices: List<MakeupMerchantDetail.Service>) :
    RecyclerView.Adapter<MakeupServiceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMakeupServiceBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(makeupServices[position])
    }

    override fun getItemCount(): Int = makeupServices.size

    class ViewHolder(private val binding: ItemMakeupServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(service: MakeupMerchantDetail.Service) {
            binding.tvMakeupServiceName.text = service.name
        }
    }

    fun refreshData(makeupServices: List<MakeupMerchantDetail.Service>) {
        this.makeupServices = makeupServices
        notifyDataSetChanged()
    }
}