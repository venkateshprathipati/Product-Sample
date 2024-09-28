package com.example.sample.data.remote

import com.example.sample.domain.model.products.ProductsModel
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts():List<ProductsModel>
}