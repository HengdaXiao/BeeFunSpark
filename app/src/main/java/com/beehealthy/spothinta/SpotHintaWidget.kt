package com.beehealthy.spothinta

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.currentState
import androidx.glance.text.Text
import com.beehealthy.spothinta.network.HintaWorker
import com.beehealthy.spothinta.network.PriceInfo
import com.beehealthy.spothinta.network.PriceInfoStateDefinition

class SpotHintaWidget: GlanceAppWidget() {

    override val stateDefinition = PriceInfoStateDefinition

    @Composable
    override fun Content() {
        val priceInfo = currentState<PriceInfo>()
        GlanceTheme() {
                AppWidgetColumn() {
                    Text(text = "Hello world!")
                    when(priceInfo){
                        is PriceInfo.Available -> {
                            Text(text = "The first price is ${priceInfo.hourlyForecast.first().priceNoTax}")
                        }else ->{
                        Text(text = "Load price failed")
                    }
                    }
                }
            }
        }
}


class SpotHintaWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = SpotHintaWidget()

    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        HintaWorker.enqueue(context)
    }

    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        HintaWorker.cancel(context)
    }
}