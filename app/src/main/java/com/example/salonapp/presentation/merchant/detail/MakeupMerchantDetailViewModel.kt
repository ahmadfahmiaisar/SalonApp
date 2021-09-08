package com.example.salonapp.presentation.merchant.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.base.dispatcher.DispatcherProvider
import com.example.base.extension.onError
import com.example.base.extension.onSuccess
import com.example.base.state.ViewState
import com.example.salonapp.domain.entity.merchant.MakeupMerchantDetail
import com.example.salonapp.domain.usecase.merchant.GetMakeupMerchantDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MakeupMerchantDetailViewModel @Inject constructor(
    private val getMakeupMerchantDetailUseCase: GetMakeupMerchantDetailUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _merchantDetail = MutableLiveData<ViewState<MakeupMerchantDetail>>()
    val merchantDetail = liveData { emitSource(_merchantDetail) }

    fun getMakeupMerchantDetail(idMerchant: String) {
        _merchantDetail.value = ViewState.Loading
        viewModelScope.launch(dispatcherProvider.io) {
            getMakeupMerchantDetailUseCase
                .invoke(idMerchant)
                .onSuccess { detail -> _merchantDetail.postValue(ViewState.Success(detail)) }
                .onError { cause -> _merchantDetail.postValue(ViewState.Error(cause)) }
        }
    }
}