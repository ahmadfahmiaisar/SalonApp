package com.example.salonapp.presentation.merchant.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.base.abstraction.BaseActivity
import com.example.base.extension.loadUrl
import com.example.base.state.ViewState
import com.example.salonapp.databinding.ActivityMakeupMerchantDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MakeupMerchantDetailActivity :
    BaseActivity<ActivityMakeupMerchantDetailBinding, MakeupMerchantDetailViewModel>() {
    override val getViewBinding: (LayoutInflater) -> ActivityMakeupMerchantDetailBinding
        get() = ActivityMakeupMerchantDetailBinding::inflate
    override val getViewModelClass: Class<MakeupMerchantDetailViewModel>
        get() = MakeupMerchantDetailViewModel::class.java

    companion object {
        private const val INTENT_KEY_ID_MERCHANT = "idMerchant"

        @JvmStatic
        fun start(context: Context, idMerchant: String) {
            val starter = Intent(context, MakeupMerchantDetailActivity::class.java)
                .putExtra(INTENT_KEY_ID_MERCHANT, idMerchant)
            context.startActivity(starter)
        }
    }

    private var idMerchant: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeMakeupMerchantDetail()
        handleIntentArguments()
        vm.getMakeupMerchantDetail(idMerchant)
    }

    private fun handleIntentArguments() {
        val intent = intent.extras ?: return
        idMerchant = intent.getString(INTENT_KEY_ID_MERCHANT) ?: return
    }

    private fun observeMakeupMerchantDetail() {
        vm.merchantDetail.observe(this, {
            when (it) {
                is ViewState.Loading -> {

                }
                is ViewState.Success -> {
                    binding.ivUserImage.loadUrl(it.data.avatar)
                }
                is ViewState.Error -> {

                }
            }
        })
    }
}