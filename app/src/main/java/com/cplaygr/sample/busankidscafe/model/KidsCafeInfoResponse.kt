package com.cplaygr.sample.busankidscafe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KidsCafeInfoResponse(
    @Expose
    @SerializedName(value = "getKidsCafeInfo")
    val kidsCafeInfo: KidsCafeInfo
)

data class KidsCafeInfo(
    @Expose
    @SerializedName(value = "header")
    val header: HeaderModel,

    @Expose
    @SerializedName(value = "item")
    val itemModelList: ArrayList<ItemModel>,

    @Expose
    @SerializedName(value = "numOfRows")
    val numOfRows: Int,

    @Expose
    @SerializedName(value = "pageNo")
    val pageNo: Int,

    @Expose
    @SerializedName(value = "totalCount")
    val totalCount: Int
)