package com.morganz.skyCast.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morganz.skyCast.domain.models.WeatherData
import com.morganz.skyCast.domain.models.WeatherInfo
import com.morganz.skyCast.domain.models.WeatherType
import com.morganz.skyCast.ui.theme.DarkBlue
import com.morganz.skyCast.ui.theme.DeepBlue
import com.morganz.skyCast.ui.theme.Shapes
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(DeepBlue)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = modifier.padding(8.dp),
                shape = Shapes.medium,
                colors = CardDefaults.cardColors(containerColor = backgroundColor)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Today ${
                            data.time.format(
                                DateTimeFormatter.ofPattern("HH:mm")
                            )
                        }",
                        modifier = Modifier.align(Alignment.End),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        modifier = Modifier.width(200.dp),
                        painter = painterResource(id = data.weatherType.iconRes),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "${data.temperatureCelsius}°C",
                        fontSize = 50.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = data.weatherType.weatherDesc,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    WeatherInfoRow(
                        state = state,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
            WeatherForecast(
                state = state,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

    }
}


@Preview
@Composable
fun WeatherCardPreview() {
    WeatherCard(
        state = WeatherState(
            weatherInfo = WeatherInfo(
                weatherDataPerDay = mapOf(
                    0 to listOf(
                        WeatherData(
                            time = LocalDateTime.now(),
                            temperatureCelsius = 20.0,
                            pressure = 1000.0,
                            windSpeed = 10.0,
                            humidity = 50.0,
                            weatherType = WeatherType.ClearSky
                        )
                    )
                ),
                currentWeatherData = WeatherData(
                    time = LocalDateTime.now(),
                    temperatureCelsius = 20.0,
                    pressure = 1000.0,
                    windSpeed = 10.0,
                    humidity = 50.0,
                    weatherType = WeatherType.Foggy
                )
            )
        ),
        backgroundColor = DarkBlue
    )
}