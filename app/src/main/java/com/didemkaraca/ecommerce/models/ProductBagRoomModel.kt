package com.didemkaraca.ecommerce.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class ProductBagRoomModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int = 0,

    @ColumnInfo(name = "name")
    var Name: String?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "price")
    var Price: String?,

    @ColumnInfo(name = "image")
    var image: String?
)
