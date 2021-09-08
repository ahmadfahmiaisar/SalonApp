package com.example.apiclient

import com.example.apiclient.state.ApiResponse
import retrofit2.Response

interface ApiClient {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResponse<Exception, T>
}