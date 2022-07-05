package com.example.carttask.features.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.carttask.R
import com.example.carttask.databinding.RowCartListBinding
import com.example.entities.Product

class CartAdapter(
    private val context: Context,
    private val arrayList: ArrayList<Product>,
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CartAdapter.CartViewHolder {
        val rowCartListBinding: RowCartListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.row_cart_list,
            parent,
            false
        )
        return CartViewHolder(rowCartListBinding)
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


    inner class CartViewHolder(private val binding: RowCartListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvProduct.text = product.name

        }

    }

}