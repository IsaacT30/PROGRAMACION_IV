package com.example.basics

fun main(){
    print("Operadores logicos")
    val edad: Int = 25
    val entrenamiento: Boolean = true
    val nivel: Int= 0
    val esApto = edad>= 18 && entrenamiento && nivel > 5
    val necesitaAyuda = !entrenamiento || nivel < 3

    println("Es apto: ${esApto}")
    println("Necesita Ayuda: ${necesitaAyuda}")

}







