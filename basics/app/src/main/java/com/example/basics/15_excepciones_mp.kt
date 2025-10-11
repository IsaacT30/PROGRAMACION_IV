package com.example.basics

fun main() {
    try {
        println("Registro de historia clínica")
        val temperatura = 38 / 0  // simulamos un error en el cálculo
        println("Temperatura registrada: $temperatura °C")
    } catch (e: Exception) {
        println(e)
        println("⚠️ Error al registrar los datos del paciente")
    }
}
