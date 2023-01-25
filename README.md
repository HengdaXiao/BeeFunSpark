# BeeFun Day Spark Android Workshop

# Objetive

Building an Android app widget tracks the daily electricity price.

# How does it look like

[https://www.figma.com/file/eyXeKoCj3O3mVi2I5jglcz/BeeFun---Spark?node-id=0%3A1&t=3n1wDQnSCRn7XvHy-1](https://www.figma.com/file/eyXeKoCj3O3mVi2I5jglcz/BeeFun---Spark?node-id=0%3A1&t=3n1wDQnSCRn7XvHy-1)
![Screenshot_1674632263](https://user-images.githubusercontent.com/2103233/214534337-820bde55-356a-4d58-9919-1bc942c91e56.png)



# Datasource

[https://api.spot-hinta.fi/Today](https://api.spot-hinta.fi/Today)

```json
[
  {
    "Rank": 7,
    "DateTime": "2023-01-25T00:00:00+02:00",
    "PriceNoTax": 0.0207,
    "PriceWithTax": 0.0228
  },
  {
    "Rank": 6,
    "DateTime": "2023-01-25T01:00:00+02:00",
    "PriceNoTax": 0.0136,
    "PriceWithTax": 0.0149
  },
  {
    "Rank": 4,
    "DateTime": "2023-01-25T02:00:00+02:00",
    "PriceNoTax": 0.009,
    "PriceWithTax": 0.0099
  },
  {
    "Rank": 2,
    "DateTime": "2023-01-25T03:00:00+02:00",
    "PriceNoTax": 0.0046,
    "PriceWithTax": 0.0050
  },
  {
    "Rank": 1,
    "DateTime": "2023-01-25T04:00:00+02:00",
    "PriceNoTax": 0.0041,
    "PriceWithTax": 0.0045
  },
  {
    "Rank": 3,
    "DateTime": "2023-01-25T05:00:00+02:00",
    "PriceNoTax": 0.0061,
    "PriceWithTax": 0.0067
  },
  {
    "Rank": 5,
    "DateTime": "2023-01-25T06:00:00+02:00",
    "PriceNoTax": 0.0112,
    "PriceWithTax": 0.0123
  },
  {
    "Rank": 8,
    "DateTime": "2023-01-25T07:00:00+02:00",
    "PriceNoTax": 0.0260,
    "PriceWithTax": 0.0286
  },
  {
    "Rank": 9,
    "DateTime": "2023-01-25T08:00:00+02:00",
    "PriceNoTax": 0.0279,
    "PriceWithTax": 0.0307
  },
  {
    "Rank": 16,
    "DateTime": "2023-01-25T09:00:00+02:00",
    "PriceNoTax": 0.0292,
    "PriceWithTax": 0.0321
  },
  {
    "Rank": 17,
    "DateTime": "2023-01-25T10:00:00+02:00",
    "PriceNoTax": 0.0294,
    "PriceWithTax": 0.0323
  },
  {
    "Rank": 13,
    "DateTime": "2023-01-25T11:00:00+02:00",
    "PriceNoTax": 0.0291,
    "PriceWithTax": 0.0320
  },
  {
    "Rank": 14,
    "DateTime": "2023-01-25T12:00:00+02:00",
    "PriceNoTax": 0.0291,
    "PriceWithTax": 0.0320
  },
  {
    "Rank": 11,
    "DateTime": "2023-01-25T13:00:00+02:00",
    "PriceNoTax": 0.0285,
    "PriceWithTax": 0.0313
  },
  {
    "Rank": 10,
    "DateTime": "2023-01-25T14:00:00+02:00",
    "PriceNoTax": 0.0282,
    "PriceWithTax": 0.0310
  },
  {
    "Rank": 12,
    "DateTime": "2023-01-25T15:00:00+02:00",
    "PriceNoTax": 0.0286,
    "PriceWithTax": 0.0315
  },
  {
    "Rank": 15,
    "DateTime": "2023-01-25T16:00:00+02:00",
    "PriceNoTax": 0.0291,
    "PriceWithTax": 0.0320
  },
  {
    "Rank": 18,
    "DateTime": "2023-01-25T17:00:00+02:00",
    "PriceNoTax": 0.0300,
    "PriceWithTax": 0.0330
  },
  {
    "Rank": 19,
    "DateTime": "2023-01-25T18:00:00+02:00",
    "PriceNoTax": 0.0308,
    "PriceWithTax": 0.0338
  },
  {
    "Rank": 23,
    "DateTime": "2023-01-25T19:00:00+02:00",
    "PriceNoTax": 0.0320,
    "PriceWithTax": 0.0352
  },
  {
    "Rank": 22,
    "DateTime": "2023-01-25T20:00:00+02:00",
    "PriceNoTax": 0.0319,
    "PriceWithTax": 0.0350
  },
  {
    "Rank": 21,
    "DateTime": "2023-01-25T21:00:00+02:00",
    "PriceNoTax": 0.0315,
    "PriceWithTax": 0.0347
  },
  {
    "Rank": 24,
    "DateTime": "2023-01-25T22:00:00+02:00",
    "PriceNoTax": 0.0330,
    "PriceWithTax": 0.0364
  },
  {
    "Rank": 20,
    "DateTime": "2023-01-25T23:00:00+02:00",
    "PriceNoTax": 0.0312,
    "PriceWithTax": 0.0343
  }
]
```

# A new way to create app widget

The out of fashion way to create the app widget uses AppWidgetProvider and RemoteViews which is out of the scope of workshop. 

[Create a simple widget | Android Developers](https://developer.android.com/develop/ui/views/appwidgets)

[Glance](https://developer.android.com/jetpack/androidx/releases/glance) is a recent addition to the suite of [Jetpack](https://developer.android.com/jetpack) libraries. It was introduced to make it faster and easier to build app widgets for surfaces such as the home screen.

Glance is built on top of the Jetpack Compose runtime and requires [Compose](https://developer.android.com/jetpack/compose) to be enabled in order to be used. It offers a declarative API, and provides a set of composables to simplify app widget UI development.

# Building up the foundation

## 1. Creating app widget

```kotlin
class SparkWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
				Text(text = "Hello world!")
    }
}
```

## 2. Providing app widget

```kotlin
class SparkWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = SparkWidget()
}
```

## 3. Registering the widget receiver

```xml
<receiver
            android:name=".SparkWidgetReceiver"
            android:enabled="@bool/glance_appwidget_available"
            android:exported="false">
            <intent-filter>
                <action android:name="android.appwidget.action.APPWIDGET_UPDATE" />
            </intent-filter>

            <meta-data
                android:name="android.appwidget.provider"
                android:resource="@xml/spark_widget" />
        </receiver>
```

## 4. ****Defining the widget’s metadata****

```xml
<?xml version="1.0" encoding="utf-8"?>
<appwidget-provider xmlns:android="http://schemas.android.com/apk/res/android"
    android:description="@string/app_name"
    android:minWidth="138dp"
    android:minHeight="138dp"
    android:minResizeWidth="120dp"
    android:minResizeHeight="120dp"
    android:resizeMode="horizontal|vertical"
    android:initialLayout="@layout/widget_loading"
    android:previewLayout="@layout/widget_preview"
    android:targetCellWidth="3"
    android:targetCellHeight="2"
    android:widgetCategory="home_screen"
    />
```

# Managing State

## 1. Providing the GlanceStateDefinition

```kotlin
/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.beehealthy.spothinta.network

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import androidx.datastore.dataStoreFile
import androidx.glance.state.GlanceStateDefinition
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.File
import java.io.InputStream
import java.io.OutputStream

/**
 * Provides our own definition of "Glance state" using Kotlin serialization.
 */
object PriceInfoStateDefinition : GlanceStateDefinition<PriceInfo> {

    private const val DATA_STORE_FILENAME = "priceInfo"

    /**
     * Use the same file name regardless of the widget instance to share data between them
     *
     * If you need different state/data for each instance, create a store using the provided fileKey
     */
    private val Context.datastore by dataStore(DATA_STORE_FILENAME, PriceInfoSerializer)

    override suspend fun getDataStore(context: Context, fileKey: String): DataStore<PriceInfo> {
        return context.datastore
    }

    override fun getLocation(context: Context, fileKey: String): File {
        return context.dataStoreFile(DATA_STORE_FILENAME)
    }

    /**
     * Custom serializer for PriceInfo using Json.
     */
    object PriceInfoSerializer : Serializer<PriceInfo> {

        override val defaultValue = PriceInfo.Unavailable("No Price Info Available")

        override suspend fun readFrom(input: InputStream): PriceInfo = try {
            Json.decodeFromString(
                PriceInfo.serializer(),
                input.readBytes().decodeToString()
            )
        } catch (exception: SerializationException) {
            throw CorruptionException("Could not read weather data: ${exception.message}")
        }

        override suspend fun writeTo(t: PriceInfo, output: OutputStream) {
            output.use {
                it.write(
                    Json.encodeToString(PriceInfo.serializer(), t).encodeToByteArray()
                )
            }
        }
    }
}
```

## 2. Fetching data

```kotlin
/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.beehealthy.spothinta.network

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.appwidget.updateAll
import androidx.work.*
import androidx.work.WorkerParameters
import com.beehealthy.spothinta.SparkWidget
import java.time.Duration

class SparkWorker(
    private val context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    companion object {

        private val uniqueWorkName = SparkWorker::class.java.simpleName

        /**
         * Enqueues a new worker to refresh electricity data only if not enqueued already
         *
         * Note: if you would like to have different workers per widget instance you could provide
         * the unique name based on some criteria .
         *
         * @param force set to true to replace any ongoing work and expedite the request
         */
        fun enqueue(context: Context, force: Boolean = false) {
            val manager = WorkManager.getInstance(context)
            val requestBuilder = PeriodicWorkRequestBuilder<SparkWorker>(
                Duration.ofMinutes(30)
            )
            var workPolicy = ExistingPeriodicWorkPolicy.KEEP

            // Replace any enqueued work and expedite the request
            if (force) {
                workPolicy = ExistingPeriodicWorkPolicy.REPLACE
            }

            manager.enqueueUniquePeriodicWork(
                uniqueWorkName,
                workPolicy,
                requestBuilder.build()
            )
        }

        /**
         * Cancel any ongoing worker
         */
        fun cancel(context: Context) {
            WorkManager.getInstance(context).cancelUniqueWork(uniqueWorkName)
        }
    }

    override suspend fun doWork(): Result {
        val manager = GlanceAppWidgetManager(context)
        val glanceIds = manager.getGlanceIds(SparkWidget::class.java)
        return try {
            setWidgetState(glanceIds, SparkRepo.getPrices())
            Result.success()
        } catch (e: Exception) {
            if (runAttemptCount < 10) {
                // Exponential backoff strategy will avoid the request to repeat
                // too fast in case of failures.
                Result.retry()
            } else {
                Result.failure()
            }
        }
    }

    /**
     * Update the state of all widgets and then force update UI
     */
    private suspend fun setWidgetState(glanceIds: List<GlanceId>, newState: PriceInfo) {
        glanceIds.forEach { glanceId ->
            updateAppWidgetState(
                context = context,
                definition = PriceInfoStateDefinition,
                glanceId = glanceId,
                updateState = { newState }
            )
        }
        SparkWidget().updateAll(context)
    }
}
```

# Populating data to the UI

```kotlin
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
                            text = "${priceInfo.hourlyPrices.first().priceWithTax} ${
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
                            text = "${priceInfo.hourlyPrices.last().priceWithTax} ${
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
                        Text(text =  LocalContext.current.getString(R.string.widget_load_failed))
                    }
                }
            }
        }
    }
}
```
