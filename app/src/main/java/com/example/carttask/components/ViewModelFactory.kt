package com.example.carttask.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carttask.features.cart.CartViewModel
import com.example.carttask.features.home.HomeViewModel

class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel() as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel() as T
            }
            else -> {
                throw IllegalArgumentException("UnknownViewModel")
            }
        }
    }

}