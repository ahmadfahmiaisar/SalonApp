package com.example.base.di

import com.example.base.apiclient.ApiClient
import com.example.base.apiclient.ApiClientImpl
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