package com.didemkaraca.ecommerce.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.didemkaraca.ecommerce.BR
import com.didemkaraca.ecommerce.R
import com.didemkaraca.ecommerce.databinding.CategoryItemBinding

class CategoryAdapter (val categoryList:List<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val categoryBinding=DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.category_item,parent,false)
        return CategoryViewHolder(categoryBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
     (holder as CategoryViewHolder ). onBind(categoryList.get(position))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class  CategoryViewHolder(val categoryBinding: ViewDataBinding):RecyclerView.ViewHolder(categoryBinding.root){
        fun onBind(productModel:String){
            val binding=categoryBinding as CategoryItemBinding
            binding.category.text=productModel
            binding.setVariable(BR.itemproduct,productModel)
        }
    }
}