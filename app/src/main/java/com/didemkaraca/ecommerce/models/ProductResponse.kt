package com.didemkaraca.ecommerce.models

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("products") var products: List<ProductModel>,


)
