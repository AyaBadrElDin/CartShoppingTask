package com.example.carttask.features.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.business.usecase.checkDateToDate
import com.example.business.usecase.getCartSaved
import com.example.carttask.R
import com.example.carttask.components.ProductEventListener
import com.example.carttask.components.ViewModelFactory
import com.example.carttask.components.toastMessage
import com.example.carttask.databinding.ActivityHomeBinding
import com.example.carttask.features.cart.CartActivity
import com.example.carttask.service.DateChangeReceiver
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_home_cart, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cart_action -> {
                checkIfCartIsNotNull()
            }
        }
        return super.onOptionsItemSelected(item)

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
        toastMessage(this,getString(R.string.product_added))
    }



    private fun checkIfCartIsNotNull() {
        if (getCartSaved() != null) {
            startActivity(Intent(this, CartActivity::class.java))
        } else {
            toastMessage(this,getString(R.string.cart_empty_message))
        }
    }
    private val dateChangeBroadCastReceiver = object : DateChangeReceiver() {

        override fun onOpenAppCheckDateChanged() {
            checkDateToDate()
        }
    }

    override fun onResume() {
        super.onResume()
        if(getCartSaved()!=null)
        registerReceiver(dateChangeBroadCastReceiver, DateChangeReceiver.getIntentFilter())
    }
    override fun onPause() {
        super.onPause()
        unregisterReceiver(dateChangeBroadCastReceiver)
    }
}