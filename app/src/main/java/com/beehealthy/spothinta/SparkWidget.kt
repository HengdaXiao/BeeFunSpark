package com.beehealthy.spothinta

import android.appwidget.AppWidgetManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.text.Text
import com.beehealthy.spothinta.network.PriceInfoStateDefinition
import com.beehealthy.spothinta.network.SparkWorker

class SparkWidget : GlanceAppWidget() {

    override val stateDefinition = PriceInfoStateDefinition

    @Composable
    override fun Content() {
        Text(text = "Hello World")
    }
}


class SparkWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = SparkWidget()

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        SparkWorker.enqueue(context)
    }

    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        SparkWorker.enqueue(context)
    }

    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        SparkWorker.cancel(context)
    }
}