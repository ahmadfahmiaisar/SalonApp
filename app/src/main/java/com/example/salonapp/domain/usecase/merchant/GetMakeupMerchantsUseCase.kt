package com.example.salonapp.domain.usecase.merchant

import com.example.base.abstraction.UseCase
import com.example.base.state.Either
import com.example.salonapp.domain.entity.merchant.MakeupMerchant
import com.example.salonapp.domain.repository.CustomerRepository
import javax.inject.Inject

class GetMakeupMerchantsUseCase @Inject constructor(private val repository: CustomerRepository) :
    UseCase<UseCase.None, Either<Exception, List<MakeupMerchant>>> {
    override suspend fun invoke(params: UseCase.None): Either<Exception, List<MakeupMerchant>> {
        return repository.getMakeupMerchants()
    }

}