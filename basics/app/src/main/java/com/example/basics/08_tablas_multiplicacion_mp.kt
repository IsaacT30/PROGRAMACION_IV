package com.example.basics

fun main() {
    println("Cálculo de Dosis Médica")
    print("Ingrese la dosis base por paciente (mg): ")

    val dosisBase: Int = readLine()?.toIntOrNull() ?: 0

    println("Cálculo de dosis para 10 pacientes con base de $dosisBase mg")

    for (i in 1..10) {
        println("Paciente $i → Dosis total: ${dosisBase * i} mg")
    }
}