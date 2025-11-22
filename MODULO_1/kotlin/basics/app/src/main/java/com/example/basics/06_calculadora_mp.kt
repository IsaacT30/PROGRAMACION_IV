package com.example.basics

fun main() {
    println("Cálculos Médicos - Operadores Aritméticos")
    println("Ingrese el peso del paciente (kg):")
    val peso: Int = readLine()?.toIntOrNull() ?: 0
    println("Ingrese la dosis por kilogramo (mg/kg):")
    val dosisPorKg: Int = readLine()?.toIntOrNull() ?: 0

    println("Suma total (peso + dosis): ${peso + dosisPorKg}")
    println("Resta (peso - dosis): ${peso - dosisPorKg}")
    println("División (peso / dosis): ${if (dosisPorKg != 0) peso / dosisPorKg else "No se puede dividir entre 0"}")
    println("Multiplicación (peso × dosis): ${peso * dosisPorKg}")
}
