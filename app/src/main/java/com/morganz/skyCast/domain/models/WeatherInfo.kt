package com.morganz.skyCast.domain.models


data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>> = emptyMap(),
    val currentWeatherData: WeatherData?
)
