package com.example.apiclient.di

import com.example.apiclient.ApiClient
import com.example.apiclient.ApiClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class ApiModule {
    @Binds
    internal abstract fun provideApi(apiClientImpl: ApiClientImpl): ApiClient
}