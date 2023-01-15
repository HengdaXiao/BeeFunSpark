package com.beehealthy.spothinta

import ApiHelperImpl
import RetrofitBuilder
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TestViewModel: ViewModel() {
    val apiHelperImpl = ApiHelperImpl(RetrofitBuilder.apiService)

    init {
        viewModelScope.launch {
            try {
                val prices = apiHelperImpl.getPrices()
                Log.d("HINTA","Fetch Price exception ${prices.toString()}")
            }catch(e:Exception) {
                Log.d("HINTA","Fetch Price exception $e")
            }
        }
    }
}