package com.example.salonapp.data.service

import com.example.salonapp.data.response.MakeupMerchantDto
import retrofit2.Response
import retrofit2.http.GET

interface CustomerService {

    @GET("api/v1/list-artisan")
    suspend fun getMakeupMerchants(): Response<List<MakeupMerchantDto>>
}