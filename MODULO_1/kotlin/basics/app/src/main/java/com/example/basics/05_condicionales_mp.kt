package com.example.basics

fun main() {
    println("Operadores Aritméticos")
    println("Condicionales en Historias Clínicas")

    val edadPaciente1 = 45
    val edadPaciente2 = 32

    if (edadPaciente1 > edadPaciente2) {
        println("El paciente de mayor edad tiene ${edadPaciente1} años")
    } else {
        println("El paciente de mayor edad tiene ${edadPaciente2} años")
    }

    fun main() {
        println("Clasificación según nivel de gravedad")

        val gravedad: Int = 7

        if (gravedad > 8) {
            println("Emergencia crítica")
        } else if (gravedad > 5) {
            println("Hospitalización necesaria")
        } else {
            println("Atención ambulatoria")
        }
    }
}