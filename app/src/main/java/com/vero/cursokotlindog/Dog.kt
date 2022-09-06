package com.vero.cursokotlindog

import com.squareup.moshi.Json

//Requerimiento para DiffCallback
data class Dog(
    val id:            Long,
    val index:         Int,
    val name:          String,
    val type:          String,
    val heightFemale:  String,
    val heightMale:    String,
    val imageUrl:      String,
    val lifeExpectancy: String,
    val temperament:   String,
    val weightFemale:  String,
    val weightMale:    String
)