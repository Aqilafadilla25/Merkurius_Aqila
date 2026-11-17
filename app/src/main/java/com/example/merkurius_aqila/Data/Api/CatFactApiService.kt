package com.example.merkurius_aqila.Data.Api

import com.example.merkurius_aqila.Data.Model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}