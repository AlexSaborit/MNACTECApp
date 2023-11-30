package com.example.mnactecapp

import java.io.Serializable

class Element (val numInventory: Int,
               val field: Int,
               val nameElement: String,
               val image: String,
               val description: String,
               val autonomy: Int,
               val disposalCapacity: Int,
               val cicle: String,
               val cilindrada: Int,
               val wingspan: Int,
               val energyFont: String,
               val sourceIncome: String,
               val formIncome: String,
               val manufacturingPlace: String,
               val length: Int,
               val weight: Int,
               val potency: Int,
               val kmsDone: Int,
               val sostreMaximDeVol: Int,
               val speed: Int,
               val maxSpeed: Int,
               val inicialElement: Boolean ) : Serializable
