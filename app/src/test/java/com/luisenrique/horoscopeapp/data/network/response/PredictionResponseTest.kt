package com.luisenrique.horoscopeapp.data.network.response

import com.luisenrique.horoscopeapp.motherobject.HoroscopeMotherObject
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest{

    @Test
    fun `toDomain Should Return A Correct PredictionModel`(){
        //Given
        val horoscopeResponse = HoroscopeMotherObject.anyResponse
        //When
        val predictionModel = horoscopeResponse.toDomain()
        //Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe  horoscopeResponse.horoscope
    }
}