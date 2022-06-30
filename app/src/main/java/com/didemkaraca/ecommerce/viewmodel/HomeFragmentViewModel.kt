package com.didemkaraca.ecommerce.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.didemkaraca.ecommerce.models.ProductModel
import com.didemkaraca.ecommerce.repo.ProductRepo

class HomeFragmentViewModel ():ViewModel(){
    private var productRepository= ProductRepo()
    private var _productList= MutableLiveData<List<ProductModel>>()
    val productList:LiveData<List<ProductModel>>
    get()=_productList



    init{
        getProducts()
    }
    private fun getProducts(){
        productRepository.products()
        _productList=productRepository.productList
    }

}