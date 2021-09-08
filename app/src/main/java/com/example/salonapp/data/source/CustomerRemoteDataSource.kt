package com.example.salonapp.data.source

import com.example.apiclient.ApiClient
import com.example.apiclient.state.ApiResponse
import com.example.base.state.Either
import com.example.salonapp.data.response.merchant.MakeupMerchantDetailDto
import com.example.salonapp.data.response.merchant.MakeupMerchantDto
import com.example.salonapp.data.service.CustomerService
import javax.inject.Inject

class CustomerRemoteDataSource @Inject constructor(
    private val apiClient: com.example.apiclient.ApiClient,
    private val service: CustomerService
) {
    suspend fun getMakeupMerchants(): Either<Exception, List<MakeupMerchantDto>> {
        val response = apiClient.safeApiCall { service.getMakeupMerchants() }
        return when (response) {
            is com.example.apiclient.state.ApiResponse.Success -> Either.Success(response.data)
            is com.example.apiclient.state.ApiResponse.Failure -> Either.Failure(response.cause)
        }
    }

    suspend fun getMakeupMerchantDetail(idMerchant: String): Either<Exception, MakeupMerchantDetailDto> {
        val response = apiClient.safeApiCall { service.getMakeupMerchantDetail(idMerchant) }
        return when (response) {
            is com.example.apiclient.state.ApiResponse.Success -> Either.Success(response.data)
            is com.example.apiclient.state.ApiResponse.Failure -> Either.Failure(response.cause)
        }
    }

}