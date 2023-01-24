package com.beehealthy.spothinta

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.beehealthy.spothinta.network.PriceInfo
import com.beehealthy.spothinta.network.PriceInfoStateDefinition
import com.beehealthy.spothinta.network.SparkWorker
import com.beehealthy.spothinta.utils.AppWidgetColumn
import com.beehealthy.spothinta.utils.GlanceTheme

class SparkWidget : GlanceAppWidget() {

    override val stateDefinition = PriceInfoStateDefinition

    @Composable
    override fun Content() {
        val priceInfo = currentState<PriceInfo>()
        GlanceTheme {
            AppWidgetColumn(modifier = GlanceModifier.background(ImageProvider(R.drawable.ic_widget_background))) {
                Text(
                    text = LocalContext.current.getString(R.string.widget_today),
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = GlanceTheme.colors.onPrimary
                    )
                )
                when (priceInfo) {
                    is PriceInfo.Available -> {
                        Text(
                            text = LocalContext.current.getString(R.string.widget_lowest),
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Medium,
                                color = GlanceTheme.colors.onPrimary
                            )
                        )
                        Text(
                            text = "${priceInfo.hourlyForecast.first().priceWithTax} ${
                                LocalContext.current.getString(
                                    R.string.widget_unit
                                )
                            }",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = GlanceTheme.colors.primary
                            )
                        )
                        Text(
                            text = LocalContext.current.getString(R.string.widget_highest),
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Medium,
                                color = GlanceTheme.colors.onPrimary
                            )
                        )
                        Text(
                            text = "${priceInfo.hourlyForecast.last().priceWithTax} ${
                                LocalContext.current.getString(
                                    R.string.widget_unit
                                )
                            }",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = GlanceTheme.colors.secondary
                            )
                        )
                    }
                    else -> {
                        Text(text = LocalContext.current.getString(R.string.widget_load_failed))
                    }
                }
            }
        }
    }
}


class SparkWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = SparkWidget()

    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        SparkWorker.enqueue(context)
    }

    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        SparkWorker.cancel(context)
    }
}