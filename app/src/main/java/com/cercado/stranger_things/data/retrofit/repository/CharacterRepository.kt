package com.cercado.stranger_things.data.retrofit.repository

import com.cercado.stranger_things.data.retrofit.ServiceInstance
import com.cercado.stranger_things.data.retrofit.response.ApiResponse
import com.cercado.stranger_things.data.retrofit.response.CharacterListResponse

class CharacterRepository {
    suspend fun getCharacters(): ApiResponse<CharacterListResponse>
    {
        return try {
            val response = ServiceInstance.getCharacterService().getCharacters()
            ApiResponse.Success(response)
        } catch (e: java.lang.Exception){
            ApiResponse.Error(e)
        }
    }
}