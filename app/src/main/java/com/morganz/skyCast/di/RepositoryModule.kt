package com.morganz.skyCast.di

import com.morganz.skyCast.data.repository.RepositoryImpl
import com.morganz.skyCast.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        repositoryImpl: RepositoryImpl
    ): Repository
}