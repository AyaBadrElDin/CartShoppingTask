package com.example.carttask.components

import com.example.entities.Product

interface ProductEventListener {
    fun onAddToCartButtonClicked(product: Product)
}