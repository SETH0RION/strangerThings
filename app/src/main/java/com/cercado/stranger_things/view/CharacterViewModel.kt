package com.cercado.stranger_things.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cercado.stranger_things.data.retrofit.repository.CharacterRepository
import com.cercado.stranger_things.data.retrofit.response.ApiResponse
import com.cercado.stranger_things.model.CharacterData
import com.cercado.stranger_things.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {

    val repository = CharacterRepository()
    val characterList: MutableLiveData<List<CharacterData>> = MutableLiveData<List<CharacterData>>()

    fun getCharacterList(){
        val data = getData()
        characterList.value = data
    }

    fun getCharacterFromService(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getCharacters()
            when(response){
                is ApiResponse.Error -> {
                    //colocar error

                }
                is ApiResponse.Success -> {
                    characterList.postValue(response.data.characters)
                }
            }

        }
    }


}