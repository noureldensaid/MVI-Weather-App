package com.morganz.skyCast.data.repository

import com.morganz.skyCast.data.mappers.toWeatherInfo
import com.morganz.skyCast.data.remote.ApiService
import com.morganz.skyCast.domain.models.WeatherInfo
import com.morganz.skyCast.domain.repository.Repository
import com.morganz.skyCast.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import java.util.concurrent.CancellationException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiService
) : Repository {
    override suspend fun getWeatherData(lat: Double, long: Double): Flow<Resource<WeatherInfo>> {
        return flow {
            emit(Resource.Loading)
            val res = api.getWeatherData(lat, long)
            emit(Resource.Success(res.toWeatherInfo()))
        }.catch {
            when (it) {
                is CancellationException -> throw it
                is IOException -> emit(Resource.Error(it.message))
                is HttpException -> emit(Resource.Error(it.message(), it.code()))
                else -> emit(Resource.Error(it.message))
            }
        }
    }
}

