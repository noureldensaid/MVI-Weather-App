package com.morganz.skyCast.domain.usecases

import com.morganz.skyCast.data.location.DefaultLocationTracker
import com.morganz.skyCast.domain.repository.Repository
import javax.inject.Inject

class GetWeatherInfoUsecase @Inject constructor(
    private val repository: Repository,
    private val locationTracker: DefaultLocationTracker
) {
    suspend operator fun invoke() = locationTracker.getCurrentLocation().let { location ->
        repository.getWeatherData(location?.latitude ?: 40.416775, location?.longitude ?: -3.703790)
    }
}