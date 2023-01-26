package com.beehealthy.spothinta

import androidx.compose.runtime.Composable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.text.Text

class SparkWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
        Text(text = "Hello world!")
    }
}


class SparkWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = SparkWidget()
}