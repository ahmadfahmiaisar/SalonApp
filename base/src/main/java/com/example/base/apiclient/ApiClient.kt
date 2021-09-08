package com.example.base.apiclient

import com.example.base.state.ApiResponse
import retrofit2.Response

interface ApiClient {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResponse<Exception, T>
}