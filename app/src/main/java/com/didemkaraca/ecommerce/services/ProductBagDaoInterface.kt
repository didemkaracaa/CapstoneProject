package com.didemkaraca.ecommerce.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.didemkaraca.ecommerce.models.ProductBagRoomModel

@Dao
interface ProductBagDaoInterface {
    @Insert
    fun addProductBag(productBagRoomModel: ProductBagRoomModel)


}