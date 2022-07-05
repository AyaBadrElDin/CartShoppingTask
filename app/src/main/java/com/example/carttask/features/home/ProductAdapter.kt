package com.example.carttask.features.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.carttask.R
import com.example.carttask.components.ProductEventListener
import com.example.carttask.databinding.RowProductListBinding
import com.example.entities.Product


class ProductAdapter(
    private val context: Context,
    private val arrayList: ArrayList<Product>,
    var productEventListener: ProductEventListener
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProductAdapter.ProductViewHolder {
        val rowProductListBinding: RowProductListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.row_product_list,
            parent,
            false
        )
        return ProductViewHolder(rowProductListBinding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


    inner class ProductViewHolder(private val binding: RowProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvProduct.text = product.name

            binding.btnAddToCart.setOnClickListener {
                productEventListener.onAddToCartButtonClicked(product)
            }
        }

    }

}