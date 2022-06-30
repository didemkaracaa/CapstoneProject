package com.didemkaraca.ecommerce.services

import com.didemkaraca.ecommerce.services.Const.BASE_URL

class ApiUtil {
    companion object {

        fun getProductDaoInterface(): ProductDaoInterface {
            return ProductApiService.getClient(BASE_URL).create(ProductDaoInterface::class.java)
        }

    }
}