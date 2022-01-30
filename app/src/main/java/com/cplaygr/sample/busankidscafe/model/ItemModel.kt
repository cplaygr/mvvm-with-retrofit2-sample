package com.cplaygr.sample.busankidscafe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemModel(

    @SerializedName(value = "gugun")
    @Expose
    val city: String,

    @SerializedName(value = "cafe_nm")
    @Expose
    val cafeName: String,

    @SerializedName(value = "road_nm")
    @Expose
    val roadName: String,

    @SerializedName(value = "tel_no")
    @Expose
    val telNumber: String,

    @SerializedName(value = "lat")
    @Expose
    val latitude: String,

    @SerializedName(value = "lng")
    @Expose
    val longitude: String,

    @SerializedName(value = "data_date")
    @Expose
    val updateDate: String
)
