package com.didemkaraca.ecommerce.services

import com.didemkaraca.ecommerce.models.ProductModel
import com.didemkaraca.ecommerce.models.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApiInterface {
    @GET("get_products.php")
      fun getProductList():Call<List<ProductModel>>


}