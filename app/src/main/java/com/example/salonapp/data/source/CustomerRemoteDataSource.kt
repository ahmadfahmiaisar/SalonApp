package com.example.salonapp.data.source

import com.example.base.apiclient.ApiClient
import com.example.base.state.ApiResponse
import com.example.base.state.Either
import com.example.salonapp.data.response.MakeupMerchantDto
import com.example.salonapp.data.service.CustomerService
import javax.inject.Inject

class CustomerRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient,
    private val service: CustomerService
) {
    suspend fun getMakeupMerchants(): Either<Exception, List<MakeupMerchantDto>> {
        val response = apiClient.safeApiCall { service.getMakeupMerchants() }
        return when (response) {
            is ApiResponse.Success -> Either.Success(response.data)
            is ApiResponse.Failure -> Either.Failure(response.cause)
        }
    }

}