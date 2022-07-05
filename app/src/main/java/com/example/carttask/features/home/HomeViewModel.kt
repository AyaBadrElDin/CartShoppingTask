package com.example.carttask.features.home

import androidx.lifecycle.ViewModel
import com.example.business.usecase.ProductUseCase
import com.example.entities.Product

class HomeViewModel() : ViewModel() {

    var productList = ArrayList<Product>()
    private val productUseCase = ProductUseCase()

    init {
        productList = productUseCase.getListOfCart()
    }

    fun addProductToSaveCartData( product: Product){
        productUseCase.addProductToCart(product)
    }




}