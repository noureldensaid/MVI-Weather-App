package com.morganz.skyCast.ui

import com.morganz.skyCast.domain.models.WeatherInfo


data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
