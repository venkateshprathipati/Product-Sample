package com.example.sample.domain.repository

import com.example.sample.domain.model.products.ProductsModel
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getProducts(): Flow<List<ProductsModel>>
}