package com.cplaygr.sample.busankidscafe.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cplaygr.sample.busankidscafe.model.KidsCafeInfoResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KidsCafeRepository {

    companion object {
        private const val TAG = "KidsCafeRepository"
        private const val BASE_URL = "http://apis.data.go.kr/6260000/"
    }

    private lateinit var kidsCafeSearchService: KidsCafeSearchService
    private var kidsCafeInfoMutableLiveData: MutableLiveData<KidsCafeInfoResponse> = MutableLiveData()

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        val gson: Gson = GsonBuilder().setLenient().create()

        kidsCafeSearchService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(KidsCafeSearchService::class.java)
    }

    fun searchKidsCafe(serviceKey: String, numOfRows: String, pageNo: String, resultType: String) {
        kidsCafeSearchService.searchKidsCafe(serviceKey, numOfRows, pageNo, resultType).enqueue(object : Callback<KidsCafeInfoResponse?> {
                override fun onResponse(
                    call: Call<KidsCafeInfoResponse?>,
                    response: Response<KidsCafeInfoResponse?>
                ) {
                    Log.d(TAG, "onResponse: ${GsonBuilder().setPrettyPrinting().create().toJson(response.body())}")
                    kidsCafeInfoMutableLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<KidsCafeInfoResponse?>, t: Throwable) {
                    Log.e(TAG, "onFailure: error. cause: ${t.message}")
                    kidsCafeInfoMutableLiveData.postValue(null)
                }
            })
    }

    fun getKidsCafeResponseLiveData(): LiveData<KidsCafeInfoResponse> {
        return this.kidsCafeInfoMutableLiveData
    }
}