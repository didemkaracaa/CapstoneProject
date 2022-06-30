package com.didemkaraca.ecommerce.services

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUD(
    @SerializedName("situation")
    @Expose
    val status: Int,

    @SerializedName("text")
    @Expose
    val message: String?
)
