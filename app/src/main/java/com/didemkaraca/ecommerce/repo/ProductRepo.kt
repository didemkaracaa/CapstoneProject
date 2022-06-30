package com.didemkaraca.ecommerce.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.didemkaraca.ecommerce.models.ProductModel
import com.didemkaraca.ecommerce.services.ApiUtil
import com.didemkaraca.ecommerce.services.CRUD
import com.didemkaraca.ecommerce.services.ProductDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductRepo() {

    var productList=MutableLiveData<List<ProductModel>>()
    var categoryList = MutableLiveData<List<String>>()
    private val productPDI:ProductDaoInterface=ApiUtil.getProductDaoInterface()
    var isProductAddedBag = MutableLiveData<Boolean>()


    fun products() {
        productPDI.products().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {

                response.body()?.let {
                    productList.value = it

                } ?: run {

                }

            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Product Sorting Failed", it) }

            }
        })
    }
    fun getCategories(){
        productPDI.getCategories().enqueue(object : Callback<List<String>?>{
            override fun onResponse(call: Call<List<String>?>, response: Response<List<String>?>) {
                response.body()?.let {
                    categoryList.value = it
                    Log.v("category","$it")
                }
            }

            override fun onFailure(call: Call<List<String>?>, t: Throwable) {
                Log.v("category","${t.localizedMessage}")
            }

        })
    }
    fun addToBag(
        user: String, title: String?, price: String?, description: String?,
        category: String?, image: String?, rate: Double?, count: Int?, sale_state: Int?
    ){
        productPDI.addToBag(user, description, price, title, category, image, rate, count,
            sale_state).enqueue(object :Callback<CRUD>{

            override fun onResponse(call: Call<CRUD>, response: Response<CRUD>) {
                response.body()?.let {
                    Log.v("POST","Successful")
                }
            }

            override fun onFailure(call: Call<CRUD>, t: Throwable) {
                if (t.localizedMessage != null){
                    Log.e("POSTFailure", t.localizedMessage!!)
                }
            }

        })
    }
    fun getBagProducts(user: String){
        productPDI.getBagProducts(user).enqueue(object : Callback<List<ProductModel>> {

            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                response.body()?.let {
                    productList.value = it
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                Log.v("Failure", t.localizedMessage!!)
            }

        })
    }



}