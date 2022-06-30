package com.didemkaraca.ecommerce.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class ProductApiService {
    companion object{
      fun getClient(baseUrl: String):Retrofit{
          return  Retrofit.Builder()
              .baseUrl(baseUrl)
              .addConverterFactory(ScalarsConverterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .build()

      }
    }

}