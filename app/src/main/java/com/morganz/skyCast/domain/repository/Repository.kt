package com.morganz.skyCast.domain.repository

import com.morganz.skyCast.domain.models.WeatherInfo
import com.morganz.skyCast.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getWeatherData(lat: Double, long: Double): Flow<Resource<WeatherInfo>>
}