package com.example.salonapp.domain.repository

import com.example.base.state.Either
import com.example.salonapp.domain.entity.merchant.MakeupMerchant
import com.example.salonapp.domain.entity.merchant.MakeupMerchantDetail

interface CustomerRepository {
    suspend fun getMakeupMerchants(): Either<Exception, List<MakeupMerchant>>
    suspend fun getMakeupMerchantDetail(idMerchant: String): Either<Exception, MakeupMerchantDetail>
}