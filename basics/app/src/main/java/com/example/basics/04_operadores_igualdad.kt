package com.example.basics

fun main() {
    println("Operadores Aritméticos")
    val nombre1: String = "Yoda"
    val nombre2: String = "Yoda"
    val nombre3: String = String("Yoda".toCharArray())

    println("Igualdad estructural (contenido)")
    println(nombre1 == nombre2)
    println(nombre1 == nombre3)

    println("Igualdad estructural (misma instancia)")
    println(nombre1 === nombre2)
    println(nombre1 === nombre3)
}