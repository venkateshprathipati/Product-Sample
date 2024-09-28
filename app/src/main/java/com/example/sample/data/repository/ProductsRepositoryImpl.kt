package com.example.sample.data.repository

import android.util.Log
import com.example.sample.data.remote.ApiService
import com.example.sample.domain.model.products.ProductsModel
import com.example.sample.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ProductsRepository {

    override suspend fun getProducts(): Flow<List<ProductsModel>> {
        return flow {
            val products = apiService.getProducts()
            emit(products)
        }.catch {
            Log.e("ProductsRepositoryImpl", "getProducts:{${it.message}}")
        }
    }
}