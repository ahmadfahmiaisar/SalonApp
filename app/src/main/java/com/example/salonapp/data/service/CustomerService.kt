package com.example.salonapp.data.service

import com.example.salonapp.data.response.merchant.MakeupMerchantDetailDto
import com.example.salonapp.data.response.merchant.MakeupMerchantDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CustomerService {

    @GET("api/v1/list-artisan")
    suspend fun getMakeupMerchants(): Response<List<MakeupMerchantDto>>

    @GET("api/v1/list-artisan/{idMerchant}")
    suspend fun getMakeupMerchantDetail(@Path("idMerchant") idMerchant: String): Response<MakeupMerchantDetailDto>
}