package com.example.business.usecase

import com.example.business.util.ProductRepository
import com.example.entities.Product

class ProductUseCase : ProductRepository {


    override fun getListOfCart(): ArrayList<Product> {
        val list = arrayListOf<Product>()
        for (i in 1..10)
            list.add(Product("Product $i"))
        return list
    }

    override fun addProductToCart(product: Product) {
        val cartSaved = getCartSaved()
        if (cartSaved != null) {
            addProductToCartSaved(cartSaved, product)
        } else {
            initCartData()
        }
    }

}