package com.beehealthy.spothinta.network

import ApiHelperImpl
import Price
import android.util.Log
import androidx.glance.LocalGlanceId
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import retrofit2.await
import java.time.Instant
import kotlin.random.Random

object HintaRepo {

    val apiHelper = ApiHelperImpl(RetrofitBuilder.apiService)

    suspend fun getPrices():PriceInfo {
        return PriceInfo.Available(apiHelper.getPrices())
    }
}