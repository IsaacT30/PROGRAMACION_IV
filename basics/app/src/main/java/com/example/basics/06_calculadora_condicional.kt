package com.example.basics

fun main() {
    println("Operadores Aritmeticos")
    val value1: Int = readLine()?.toIntOrNull()?:0
    println("Incluir segundo valor")
    val value2: Int = readLine()?.toIntOrNull()?:0

    print("Ingresa el signo de la operación")
    val signo: String = readLine() ?: ""
    when (signo) {
        "+" -> println("Resultado de la suma: ${value1 + value2}")
        "-" -> println("Resultado de la resta: ${value1 - value2}")
        "*" -> println("Resultado de la multiplicación: ${value1 * value2}")
        "/" -> {
            if (value2 != 0) {
                println("Resultado de la división: ${value1 / value2}")
            } else {
                println("Error: no se puede dividir entre cero.")
            }
        }
        else -> println("Signo inválido. Usa +, -, * o /.")
    }
}