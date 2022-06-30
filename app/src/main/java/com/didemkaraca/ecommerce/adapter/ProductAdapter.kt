package com.didemkaraca.ecommerce.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.didemkaraca.ecommerce.BR
import com.didemkaraca.ecommerce.R
import com.didemkaraca.ecommerce.databinding.ProductItemBinding
import com.didemkaraca.ecommerce.models.ProductModel
import com.squareup.picasso.Picasso


class ProductsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val productList = ArrayList<ProductModel>()
    private val productsAdapter by lazy { ProductsAdapter() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val productBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.product_item, parent, false
        )
        return ProductViewHolder(productBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductViewHolder).onBind(productList.get(position))
    }

    override fun getItemCount(): Int {
        return productList.size
    }
    fun updateList(list: List<ProductModel>) {
        productList.clear()
        productList.addAll(list)
        notifyDataSetChanged()
    }

    class ProductViewHolder(val productBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(productBinding.root) {

        fun onBind(product: ProductModel) {

            val binding = productBinding as ProductItemBinding
            binding.setVariable(BR.itemproduct,product)

           product.image.let {
               Picasso.get().load(it).into(binding.productImage)
           }
           binding.productImage.setOnClickListener {

           }




        }


    }
}
