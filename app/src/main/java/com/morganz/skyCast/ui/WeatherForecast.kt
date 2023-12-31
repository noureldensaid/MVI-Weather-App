package com.morganz.skyCast.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morganz.skyCast.domain.models.WeatherData
import com.morganz.skyCast.ui.theme.DarkBlue
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.let { weatherDataPerDay ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Column(
                modifier = Modifier.padding(vertical = 16.dp)

            ) {
                weatherDataPerDay.entries.forEach { (dayIndex, dayData) ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (dayIndex == 0) "Today" else dayData[0].time.dayOfWeek.getDisplayName(
                            java.time.format.TextStyle.SHORT, Locale.getDefault()
                        ),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Italic
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(
                        content = {
                            items(dayData.size) {
                                HourlyWeatherDisplay(
                                    weatherData = dayData[it],
                                    modifier = Modifier.padding(end = 16.dp)
                                )
                            }
                        }
                    )
                    if (dayIndex != weatherDataPerDay.size - 1) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(DarkBlue)
                                .padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm")).toString(),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Icon(
            tint = Color.White,
            modifier = Modifier.size(30.dp),
            imageVector = ImageVector.vectorResource(id = weatherData.weatherType.iconRes),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = weatherData.temperatureCelsius.roundToInt().toString() + "°C",
            color = Color.White
        )
    }
}
