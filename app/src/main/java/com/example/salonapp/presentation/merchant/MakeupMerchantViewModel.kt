package com.example.salonapp.presentation.merchant

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.base.abstraction.UseCase
import com.example.base.dispatcher.DispatcherProvider
import com.example.base.extension.onError
import com.example.base.extension.onSuccess
import com.example.base.state.ViewState
import com.example.salonapp.domain.entity.merchant.MakeupMerchant
import com.example.salonapp.domain.usecase.merchant.GetMakeupMerchantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MakeupMerchantViewModel @Inject constructor(
    private val getMakeupMerchantsUseCase: GetMakeupMerchantsUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _makeupMerchant = MutableLiveData<ViewState<List<MakeupMerchant>>>()
    val makeupMerchant = liveData { emitSource(_makeupMerchant) }

    fun getMakeupMerchants() {
        _makeupMerchant.value = ViewState.Loading
        viewModelScope.launch(dispatcherProvider.io) {
            getMakeupMerchantsUseCase
                .invoke(UseCase.None)
                .onSuccess { merchant -> _makeupMerchant.postValue(ViewState.Success(merchant)) }
                .onError { cause -> _makeupMerchant.postValue(ViewState.Error(cause)) }
        }
    }
}