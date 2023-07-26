package com.cercado.stranger_things.model

data class CharacterData(
    val _id: String,
    val affiliation: List<String>,
    val aliases: List<String>,
    val appearsInEpisodes: List<String>,
    val born: String,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val name: String,
    val occupation: List<String>,
    val otherRelations: List<String>,
    val photo: String,
    val portrayedBy: String,
    val residence: List<String>,
    val status: String
)

fun getData(): List<CharacterData> =
    listOf(
        CharacterData("1",
            listOf(""), listOf(""),listOf(""),"Blue","Rashtc","","Ana Caren","Decrapted",listOf(""),listOf(""),"","",listOf(""),"")

    )