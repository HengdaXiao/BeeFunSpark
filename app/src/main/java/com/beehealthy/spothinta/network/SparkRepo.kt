package com.beehealthy.spothinta.network

import ApiHelperImpl

object SparkRepo {

    val apiHelper = ApiHelperImpl(RetrofitBuilder.apiService)

    suspend fun getPrices():PriceInfo {
        return PriceInfo.Available(apiHelper.getPrices())
    }
}