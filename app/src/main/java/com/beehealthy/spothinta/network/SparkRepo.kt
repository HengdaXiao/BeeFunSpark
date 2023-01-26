package com.beehealthy.spothinta.network

import ApiHelperImpl

object SparkRepo {

    val apiHelper = ApiHelperImpl(RetrofitBuilder.apiService)

    suspend fun getPrices():PriceInfo {
        val sortedPrices = apiHelper.getPrices().sortedBy { it.rank }
        val highPriceText = String.format("%.2f", sortedPrices.last().priceWithTax * 100)
        val lowPriceText = String.format("%.2f", sortedPrices.first().priceWithTax * 100)
        return PriceInfo.Available(highPriceText,lowPriceText)
    }
}