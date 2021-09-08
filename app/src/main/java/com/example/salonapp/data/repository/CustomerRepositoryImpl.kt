package com.example.salonapp.data.repository

import com.example.base.state.Either
import com.example.salonapp.data.mapper.MakeupMerchantMapper
import com.example.salonapp.data.source.CustomerRemoteDataSource
import com.example.salonapp.domain.entity.merchant.MakeupMerchant
import com.example.salonapp.domain.repository.CustomerRepository
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val remoteDataSource: CustomerRemoteDataSource,
    private val makeupMerchantMapper: MakeupMerchantMapper
) : CustomerRepository {
    override suspend fun getMakeupMerchants(): Either<Exception, List<MakeupMerchant>> {
        val apiResult = remoteDataSource.getMakeupMerchants()
        return when (apiResult) {
            is Either.Success -> Either.Success(makeupMerchantMapper.map(apiResult.data))
            is Either.Failure -> Either.Failure(apiResult.cause)
        }
    }
}