package com.cplaygr.sample.busankidscafe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HeaderModel(
    @SerializedName(value = "code")
    @Expose
    val code: String,

    @SerializedName(value = "message")
    @Expose
    val message: String
)
