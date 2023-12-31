package com.morganz.skyCast.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morganz.skycast.R
import kotlin.math.roundToInt

@Composable
fun WeatherInfoRow(
    state: WeatherState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        state.weatherInfo?.currentWeatherData.let { data ->
            WeatherDataDisplay(
                value = data?.temperatureCelsius?.roundToInt().toString(),
                unit = "hpa",
                icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                modifier = modifier
            )
            WeatherDataDisplay(
                value = data?.humidity?.roundToInt().toString(),
                unit = "%",
                icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                modifier = modifier
            )
            WeatherDataDisplay(
                value = data?.windSpeed?.roundToInt().toString(),
                unit = "km/h",
                icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                modifier = modifier
            )
        }
    }
}

@Composable
fun WeatherDataDisplay(value: String, unit: String, icon: ImageVector, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "$value$unit",
            color = Color.White,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}
