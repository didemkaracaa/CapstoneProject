package com.didemkaraca.ecommerce.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR.itembag
import androidx.recyclerview.widget.RecyclerView
import com.didemkaraca.ecommerce.BR
import com.didemkaraca.ecommerce.R
import com.didemkaraca.ecommerce.databinding.BagItamBinding
import com.didemkaraca.ecommerce.models.ProductModel
import com.squareup.picasso.Picasso

class BagAdapter(bagList: List<ProductModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val bagList = ArrayList<ProductModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bagBinding=DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.bag_itam,parent,false)
        return BagViewHolder(bagBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BagViewHolder).onBind(bagList.get(position))
    }

    override fun getItemCount(): Int {
        return bagList.size
    }
    class BagViewHolder(val bagBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(bagBinding.root) {

        fun onBind(product: ProductModel) {

            val binding = bagBinding as BagItamBinding
            binding.setVariable(BR.itembag,product)





        }


    }
}