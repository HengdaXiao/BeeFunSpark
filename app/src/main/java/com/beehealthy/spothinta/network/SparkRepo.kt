package com.beehealthy.spothinta.network

import ApiHelperImpl

object SparkRepo {

    val apiHelper = ApiHelperImpl(RetrofitBuilder.apiService)

    suspend fun getPrices():PriceInfo {
        val prices = apiHelper.getPrices().sortedBy { it.rank }
        return PriceInfo.Available(prices)
    }
}