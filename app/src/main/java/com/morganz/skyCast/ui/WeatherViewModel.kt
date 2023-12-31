package com.morganz.skyCast.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.morganz.skyCast.domain.usecases.GetWeatherInfoUsecase
import com.morganz.skyCast.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherInfoUsecase: GetWeatherInfoUsecase
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set


    fun loadWeatherInfo() {
        viewModelScope.launch {
            getWeatherInfoUsecase.invoke()?.collect {
                when (it) {
                    is Resource.Loading -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = true,
                            error = null
                        )
                    }

                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = it.data,
                            isLoading = false,
                            error = null
                        )
                        Log.e("TAG", "loadWeatherInfo: ${it.data}")
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = it.message
                        )
                        Log.e("TAG", "loadWeatherInfo: ${it.message}")
                    }

                }
            } ?: kotlin.run {
                state = state.copy(
                    weatherInfo = null,
                    isLoading = false,
                    error = "Location not found"
                )
            }
        }
    }
}


