package com.beehealthy.spothinta

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.beehealthy.spothinta.network.HintaWorker
import com.beehealthy.spothinta.network.PriceInfo
import com.beehealthy.spothinta.network.PriceInfoStateDefinition

class SpotHintaWidget: GlanceAppWidget() {

    override val stateDefinition = PriceInfoStateDefinition

    @Composable
    override fun Content() {
        val priceInfo = currentState<PriceInfo>()
        GlanceTheme() {
                AppWidgetColumn(modifier = GlanceModifier.background(ImageProvider(R.drawable.ic_widget_background))) {
                    Text(text = "Today", style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GlanceTheme.colors.onPrimary))
                    when(priceInfo){
                        is PriceInfo.Available -> {
                            Text(text = "Lowest", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium, color = GlanceTheme.colors.onPrimary))
                            Text(text = "${priceInfo.hourlyForecast.first().priceWithTax} snt/kWh", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium, color = GlanceTheme.colors.primary))
                            Text(text = "Highest", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium, color = GlanceTheme.colors.onPrimary))
                            Text(text = "${priceInfo.hourlyForecast.last().priceWithTax} snt/kWh", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium, color = GlanceTheme.colors.secondary))
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