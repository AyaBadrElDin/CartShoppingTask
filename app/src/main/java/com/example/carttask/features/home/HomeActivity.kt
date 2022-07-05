package com.example.carttask.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.carttask.R
import com.example.carttask.components.ProductEventListener
import com.example.carttask.components.ViewModelFactory
import com.example.carttask.databinding.ActivityHomeBinding
import com.example.entities.Product

class HomeActivity : AppCompatActivity(),ProductEventListener {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
        setProductAdapter()
    }
    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(HomeViewModel::class.java)
    }

    private fun setProductAdapter() {
        binding.rvProduct.adapter = ProductAdapter(this, viewModel.productList, this)
    }

    override fun onAddToCartButtonClicked(product: Product) {
        viewModel.addProductToSaveCartData(product)
    }

}