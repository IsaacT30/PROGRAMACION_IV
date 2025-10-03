package com.example.basics

fun main(){
    print("Operadores lógicos")
    val edadPaciente: Int = 45
    val tieneSeguro: Boolean = true
    val gravedad: Int = 7
    val puedeSerAtendido = edadPaciente >= 18 && tieneSeguro && gravedad > 5
    val necesitaReferencia = !tieneSeguro || gravedad < 3

    println("Puede ser atendido: ${puedeSerAtendido}")
    println("Necesita referencia: ${necesitaReferencia}")
}
