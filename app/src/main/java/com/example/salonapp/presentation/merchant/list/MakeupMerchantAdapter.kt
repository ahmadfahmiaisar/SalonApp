package com.example.salonapp.presentation.merchant.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.salonapp.databinding.ItemMakeupMerchantBinding
import com.example.salonapp.domain.entity.merchant.MakeupMerchant

class MakeupMerchantAdapter(var makeupMerchants: List<MakeupMerchant>) :
    RecyclerView.Adapter<MakeupMerchantAdapter.ViewHolder>() {

    private var onMakeupMerchantSelected: (MakeupMerchant) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMakeupMerchantBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(makeupMerchants[position], onMakeupMerchantSelected)
    }

    override fun getItemCount(): Int = makeupMerchants.size

    class ViewHolder(private val binding: ItemMakeupMerchantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(merchant: MakeupMerchant, onMakeupMerchantSelected: (MakeupMerchant) -> Unit) {
            binding.tvTitle.text = merchant.name
            binding.root.setOnClickListener { onMakeupMerchantSelected(merchant) }
        }
    }

    fun refreshData(makeupMerchants: List<MakeupMerchant>) {
        this.makeupMerchants = makeupMerchants
        notifyDataSetChanged()
    }

    fun setOnMakeupMerchantSelected(onMakeupMerchantSelected: (MakeupMerchant) -> Unit) {
        this.onMakeupMerchantSelected = onMakeupMerchantSelected
    }
}