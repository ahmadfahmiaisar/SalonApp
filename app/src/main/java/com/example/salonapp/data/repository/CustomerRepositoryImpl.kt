package com.example.salonapp.data.repository

import com.example.base.state.Either
import com.example.salonapp.data.mapper.merchant.MakeupMerchantDetailMapper
import com.example.salonapp.data.mapper.merchant.MakeupMerchantMapper
import com.example.salonapp.data.source.CustomerRemoteDataSource
import com.example.salonapp.domain.entity.merchant.MakeupMerchant
import com.example.salonapp.domain.entity.merchant.MakeupMerchantDetail
import com.example.salonapp.domain.repository.CustomerRepository
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val remoteDataSource: CustomerRemoteDataSource,
    private val makeupMerchantMapper: MakeupMerchantMapper,
    private val makeupMerchantDetailMapper: MakeupMerchantDetailMapper
) : CustomerRepository {
    override suspend fun getMakeupMerchants(): Either<Exception, List<MakeupMerchant>> {
        val apiResult = remoteDataSource.getMakeupMerchants()
        return when (apiResult) {
            is Either.Success -> Either.Success(makeupMerchantMapper.map(apiResult.data))
            is Either.Failure -> Either.Failure(apiResult.cause)
        }
    }

    override suspend fun getMakeupMerchantDetail(idMerchant: String): Either<Exception, MakeupMerchantDetail> {
        val apiResult = remoteDataSource.getMakeupMerchantDetail(idMerchant)
        return when (apiResult) {
            is Either.Success -> Either.Success(makeupMerchantDetailMapper.map(apiResult.data))
            is Either.Failure -> Either.Failure(apiResult.cause)
        }
    }
}