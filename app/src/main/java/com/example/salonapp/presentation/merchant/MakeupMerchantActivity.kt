package com.example.salonapp.presentation.merchant

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.abstraction.BaseActivity
import com.example.base.extension.gone
import com.example.base.extension.showToast
import com.example.base.extension.visible
import com.example.base.state.ViewState
import com.example.salonapp.databinding.ActivityMakeupMerchantBinding
import com.example.salonapp.domain.entity.merchant.MakeupMerchant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MakeupMerchantActivity :
    BaseActivity<ActivityMakeupMerchantBinding, MakeupMerchantViewModel>() {
    override val getViewBinding: (LayoutInflater) -> ActivityMakeupMerchantBinding
        get() = ActivityMakeupMerchantBinding::inflate
    override val getViewModelClass: Class<MakeupMerchantViewModel>
        get() = MakeupMerchantViewModel::class.java

    private val adapter by lazy { MakeupMerchantAdapter(emptyList()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeMakeupMerchants()
        vm.getMakeupMerchants()
        initRecycleView()
    }

    private fun observeMakeupMerchants() {
        vm.makeupMerchant.observe(this, {
            when (it) {
                is ViewState.Loading -> {
                    binding.progressBar.visible()
                }
                is ViewState.Success -> {
                    binding.progressBar.gone()
                    adapter.refreshData(it.data)
                    setupSearchMakeupMerchant(it.data)
                }
                is ViewState.Error -> {
                    binding.progressBar.gone()
                }
            }
        })
    }

    private fun initRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        with(binding) {
            rvMakeupMerchant.layoutManager = layoutManager
            rvMakeupMerchant.adapter = adapter
        }

        adapter.setOnMakeupMerchantSelected {
            showToast { it.name }
        }
    }

    private fun setupSearchMakeupMerchant(data: List<MakeupMerchant>) {
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.select_dialog_item, data.map { it.name })

        binding.etMerchantName.threshold = 1
        binding.etMerchantName.setAdapter(arrayAdapter)

        binding.etMerchantName.setOnItemClickListener { adapterView, _, position, _ ->
            val merchantSelected = adapterView.getItemAtPosition(position)
            data.forEach {
                if (it.name == merchantSelected) {
                    showToast { "ini ${it.name}" }
                }
            }
        }
    }
}