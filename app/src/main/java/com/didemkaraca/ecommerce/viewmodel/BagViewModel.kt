package com.didemkaraca.ecommerce.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.didemkaraca.ecommerce.models.ProductModel
import com.didemkaraca.ecommerce.repo.ProductRepo

class BagViewModel():ViewModel(){
    private var bagRepository=ProductRepo()
    private var _bagList= MutableLiveData<List<ProductModel>>()
    val bagList: LiveData<List<ProductModel>>
        get()=_bagList

    fun getBag(user:String){
        bagRepository.getBagProducts(user)
        _bagList=bagRepository.productList
    }
}