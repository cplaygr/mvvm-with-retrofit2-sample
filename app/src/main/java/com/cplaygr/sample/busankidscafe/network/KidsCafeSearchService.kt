package com.cplaygr.sample.busankidscafe.network

import com.cplaygr.sample.busankidscafe.model.KidsCafeInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KidsCafeSearchService {
    @GET(value = "BusanKidsCafeInfoService/getKidsCafeInfo")
    fun searchKidsCafe(
        @Query(value = "ServiceKey", encoded = true) serviceKey: String,
        @Query(value = "numOfRows", encoded = true) numOfRows: String,
        @Query(value = "pageNo", encoded = true) pageNo: String,
        @Query(value = "resultType", encoded = true) resultType: String
    ): Call<KidsCafeInfoResponse>
}