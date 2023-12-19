package com.luisenrique.horoscopeapp.domain

import com.luisenrique.horoscopeapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}