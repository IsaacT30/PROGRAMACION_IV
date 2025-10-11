package com.example.basics

fun main() {
    try {
        println("Registro de historia clínica")
        val temperatura = 38 / 0  //  un error
        println("Temperatura registrada: $temperatura °C")
    } catch (e: Exception) {
        println(e)
        println("⚠️ Error al registrar los datos del paciente")
    }
}
