package com.cercado.stranger_things.data.retrofit

import com.cercado.stranger_things.data.retrofit.response.CharacterListResponse
import retrofit2.http.GET

interface CharacterService {
    @GET("02312f97-6ff7-438b-af55-aefa8553b753")
    suspend fun  getCharacters() : CharacterListResponse
}