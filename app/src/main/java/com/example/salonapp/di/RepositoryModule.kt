package com.example.salonapp.di

import com.example.salonapp.data.repository.CustomerRepositoryImpl
import com.example.salonapp.domain.repository.CustomerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {
    @Binds
    fun bindCustomerRepository(repositoryImpl: CustomerRepositoryImpl): CustomerRepository
}