package com.didemkaraca.ecommerce.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.didemkaraca.ecommerce.repo.ProductRepo

class DetailViewModel(context:Context): ViewModel() {
    private var detailRepository = ProductRepo()

    private var _detailList = MutableLiveData<List<Boolean>>()
    val detailList: LiveData<List<Boolean>>
        get() = _detailList

    fun addToBag(
        user: String, title: String?, price: String?, description: String?,
        category: String?, image: String?, rate: Double?, count: Int?, sale_state: Int?
    ){
        detailRepository.addToBag(user, title, price, description, category, image, rate, count, sale_state)
    }
}