package com.example.business.usecase

import com.example.business.local.PreferencesManager
import com.example.business.util.currentDate
import com.example.business.util.dateAfter3Days
import com.example.business.util.keyCartStore
import com.example.entities.CartSaved
import com.example.entities.Product

fun initCartData() {
    var cartSaved = CartSaved()
    cartSaved.productList = arrayListOf()
    cartSaved.firstDateCartAdded = currentDate()
    cartSaved.dateAfter3Days = dateAfter3Days()
    updateCartSavedData(cartSaved)

}

fun addProductToCartSaved(
    cartSaved1: CartSaved,
    product: Product
) {
    cartSaved1.productList!!.add(product)
    updateCartSavedData(cartSaved1)

}

fun updateCartSavedData(cartSaved: CartSaved) {
    PreferencesManager.put(cartSaved, keyCartStore)
}

fun getCartSaved(): CartSaved? {
    return PreferencesManager.get<CartSaved>(keyCartStore)
}
fun checkDateToDate(){
    if(checkDateAndCompare()){
        deleteCartDataAfter3Days()
    }
}

fun deleteCartDataAfter3Days(){
    PreferencesManager.put(null, keyCartStore)
}

fun checkDateAndCompare():Boolean{
    var currentDate = currentDate();
    var cartSavedDate3days= getCartSaved()?.dateAfter3Days
    return (currentDate == cartSavedDate3days)
}