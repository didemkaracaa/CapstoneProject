package com.didemkaraca.ecommerce.services

import com.didemkaraca.ecommerce.models.ProductModel
import com.didemkaraca.ecommerce.models.ProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductDaoInterface {
    @GET("get_products.php")  //Tüm ürünler için
    fun products(): Call<List<ProductModel>>
    @GET("get_categories.php")
    fun getCategories(): Call<List<String>>

    @POST("add_to_bag.php")
    @FormUrlEncoded
    fun addToBag(
        @Field("user") user: String,
        @Field("title") title: String?,
        @Field("price") price: String?,
        @Field("description") description: String?,
        @Field("category") category: String?,
        @Field("image") image: String?,
        @Field("rate") rate: Double?,
        @Field("count") count: Int?,
        @Field("sale_state") sale_state: Int?,
    ): Call<CRUD>


    @POST("get_bag_products_by_user.php")
    @FormUrlEncoded
    fun getBagProducts(
        @Field("user") user: String
    ): Call<List<ProductModel>>



}