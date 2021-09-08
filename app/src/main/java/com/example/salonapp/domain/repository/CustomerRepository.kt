package com.example.salonapp.domain.repository

import com.example.base.state.Either
import com.example.salonapp.domain.entity.merchant.MakeupMerchant

interface CustomerRepository {
    suspend fun getMakeupMerchants(): Either<Exception, List<MakeupMerchant>>
}