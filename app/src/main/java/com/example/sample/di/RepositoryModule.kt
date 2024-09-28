package com.example.sample.di

import com.example.sample.data.repository.ProductsRepositoryImpl
import com.example.sample.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProductsRepository(productsRepositoryImpl: ProductsRepositoryImpl): ProductsRepository
}