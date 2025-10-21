package com.example.basics

fun main() {
    println("Bucles en Historias Clínicas")

    val pacientes = listOf("Isaac", "María", "Pedro", "Lucía")

    // Recorrido con índice
    for ((index, paciente) in pacientes.withIndex()) {
        println("${index + 1}. Paciente: $paciente")
    }

    // Rangos ascendentes (porcentaje de recuperación)
    for (i in 0..100 step 20) {
        println("Recuperación: $i%")
    }

    // Rangos descendentes (conteo regresivo para control de signos vitales)
    for (conteo in 10 downTo 1) {
        println("Revisión en: $conteo segundos")
    }

    // Control de flujo
    for (paciente in pacientes) {
        if (paciente == "Carlos") continue
        if (paciente == "Pedro") break
        println("Atendiendo a $paciente")
    }
}
