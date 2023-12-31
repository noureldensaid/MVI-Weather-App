package com.morganz.skyCast.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(weatherDataPath)
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto

    companion object{
        const val baseUrl = "https://api.open-meteo.com/"
        const val weatherDataPath = "v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl"
    }
}