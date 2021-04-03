package com.example.conectiontestapi.api

import com.google.gson.annotations.SerializedName

data class PersonApi(
    @SerializedName("name")
    val name: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("house")
    val house: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("yearOfBirth")
    val yearOfBirth: String,
    @SerializedName("ancestry")
    val ancestry: String,
    @SerializedName("eyeColour")
    val eyeColour: String,
    @SerializedName("hairColour")
    val hairColour: String,
    @SerializedName("hogwartsStudent")
    val hogwartsStudent: Boolean,
    @SerializedName("hogwartsStaff")
    val hogwartsStaff: Boolean,
    @SerializedName("actor")
    val actor: String,
    @SerializedName("alive")
    val alive: Boolean,
    @SerializedName("image")
    val image: String

)
