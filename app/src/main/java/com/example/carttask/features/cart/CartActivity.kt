package com.example.carttask.features.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.carttask.R
import com.example.carttask.components.ViewModelFactory
import com.example.carttask.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var viewModel: CartViewModel
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        initView()
        setCartProductSavedList()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(CartViewModel::class.java)
    }
    private fun setCartProductSavedList() {
        binding.rvCart.adapter = CartAdapter(this, viewModel.getShoppingCartList())
    }
}