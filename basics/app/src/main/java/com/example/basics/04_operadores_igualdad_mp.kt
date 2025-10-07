package com.example.basics

fun main() {
    println("Operadores Igualdad en Historias Clínicas")
    val paciente1: String = "Isaac"
    val paciente2: String = "Isaac"
    val paciente3: String = String("Isaac".toCharArray())

    println("Igualdad estructural (contenido)")
    println(paciente1 == paciente2)
    println(paciente1 == paciente3)

    println("Igualdad referencial (misma instancia)")
    println(paciente1 === paciente2)
    println(paciente1 === paciente3)
}