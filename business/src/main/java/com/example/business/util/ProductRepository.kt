package com.example.business.util

import com.example.entities.Product

interface ProductRepository {
    fun getListOfCart(): ArrayList<Product>
    fun addProductToCart(product: Product)

}