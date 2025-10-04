package com.example.basics

fun main() {
    println("Operadores Aritmeticos")
    val value1: Int = readLine()?.toIntOrNull() ?: 0
    println("Incluir segundo valor")
    val value2: Int = readLine()?.toIntOrNull() ?: 0
    println("suma:${value1 + value2}")
    println("Resta: ${value1 - value2}")
    println("division: ${value1 / value2}")
    println("multiplicacion: ${value1 * value2}")
}


