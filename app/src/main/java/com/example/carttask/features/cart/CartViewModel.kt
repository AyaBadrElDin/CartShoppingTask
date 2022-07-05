package com.example.carttask.features.cart

import androidx.lifecycle.ViewModel
import com.example.business.usecase.getCartSaved
import com.example.entities.Product

class CartViewModel() : ViewModel() {
    fun getShoppingCartList(): ArrayList<Product> = getCartSaved()?.productList!!

}

