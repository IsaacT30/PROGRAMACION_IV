package com.example.basics

fun main() {
    println("Tablas de Multiplicar")
    print("Que tabla multiplicamos?")

    val numero: Int = readLine()?.toIntOrNull() ?: 0

    println("Tabla del $numero")

    for (i in 1..10) {
        println("$numero x $i = ${numero * i}")
    }
}