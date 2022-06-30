package com.didemkaraca.ecommerce.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.didemkaraca.ecommerce.models.ProductModel
import com.didemkaraca.ecommerce.repo.ProductRepo

class ShopFragmentViewModel(function: () -> Unit) :ViewModel() {
    private var categoryRepository= ProductRepo()
    private var _categoryList= MutableLiveData<List<String>>()
    val categoryList: LiveData<List<String>>
        get()=_categoryList

    init{
        getCategory()
    }
    private fun getCategory(){
        categoryRepository.getCategories()
        _categoryList=categoryRepository.categoryList
    }

}