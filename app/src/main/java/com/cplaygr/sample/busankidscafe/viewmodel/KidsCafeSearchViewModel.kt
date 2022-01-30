package com.cplaygr.sample.busankidscafe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cplaygr.sample.busankidscafe.const.KidsCafeConst
import com.cplaygr.sample.busankidscafe.model.KidsCafeInfoResponse
import com.cplaygr.sample.busankidscafe.network.KidsCafeRepository

class KidsCafeSearchViewModel(application: Application) : AndroidViewModel(application) {

    private var kidsCafeSearchRepository: KidsCafeRepository
    private var kidsCafeInfoResponseLiveData: LiveData<KidsCafeInfoResponse>

    init {
        kidsCafeSearchRepository = KidsCafeRepository()
        kidsCafeInfoResponseLiveData = kidsCafeSearchRepository.getKidsCafeResponseLiveData()
    }

    fun searchKidsCafe() {
        kidsCafeSearchRepository.searchKidsCafe(KidsCafeConst.serviceKey, KidsCafeConst.numOfRows.toString(), KidsCafeConst.pageNo.toString(), KidsCafeConst.resultType)
    }

    fun getKidsCafeInfoResponseLiveData(): LiveData<KidsCafeInfoResponse> {
        return kidsCafeInfoResponseLiveData
    }
}