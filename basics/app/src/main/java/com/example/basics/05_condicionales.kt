package com.example.basics

fun main() {
    println("Operadores Aritméticos")
    println("Condicionales")

    val value1 = 18
    val value2 = 15

    if (value1 > value2) {
        println("El mayor es ${value1}")
    } else {
        println("El mayor es ${value2}")
    }

    fun main() {
        println("Rango según nivel de fuerza")

        val fuerza: Int = 10

        if (fuerza > 10) {
            println("maestro")
        } else if (fuerza > 5) {
            println("caballero jedi")
        } else {
            println("padawan")
        }
    }
}

