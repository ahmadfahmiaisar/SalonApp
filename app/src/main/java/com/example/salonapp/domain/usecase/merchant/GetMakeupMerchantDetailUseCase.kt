package com.example.salonapp.domain.usecase.merchant

import com.example.base.abstraction.UseCase
import com.example.base.state.Either
import com.example.salonapp.domain.entity.merchant.MakeupMerchantDetail
import com.example.salonapp.domain.repository.CustomerRepository
import javax.inject.Inject

class GetMakeupMerchantDetailUseCase @Inject constructor(private val repository: CustomerRepository) :
    UseCase<String, Either<Exception, MakeupMerchantDetail>> {
    override suspend fun invoke(params: String): Either<Exception, MakeupMerchantDetail> {
        return repository.getMakeupMerchantDetail(params)
    }

}