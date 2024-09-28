package com.example.sample.presentation.view.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample.domain.model.products.ProductsModel
import com.example.sample.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsRepository: ProductsRepository) :
    ViewModel() {

    private val _products = MutableStateFlow<List<ProductsModel>>(emptyList())
    val products: StateFlow<List<ProductsModel>> = _products.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            productsRepository.getProducts().collect {
                _products.value = it
            }
        }
    }
}