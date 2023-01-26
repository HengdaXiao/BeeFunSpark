package com.beehealthy.spothinta

import android.appwidget.AppWidgetManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.*
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.text.Text
import com.beehealthy.spothinta.network.PriceInfoStateDefinition

class SparkWidget : GlanceAppWidget() {

    override val stateDefinition = PriceInfoStateDefinition

    @Composable
    override fun Content() {
        Text(text = "Hello world!")
    }
}


class SparkWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = SparkWidget()
}