package com.luisenrique.horoscopeapp.data

import android.util.Log
import com.luisenrique.horoscopeapp.data.network.HoroscopeApiService
import com.luisenrique.horoscopeapp.domain.Repository
import com.luisenrique.horoscopeapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Luis", "Hola") }
        return null
    }
}