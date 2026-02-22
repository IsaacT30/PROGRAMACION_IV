package com.example.basics

fun main() {
    println("Listas en Historias Clínicas")

    val pacientesInmutables: List<Int> = listOf(101, 102, 103)
    println("Lista inmutable de IDs de pacientes: ${pacientesInmutables}")

    val pacientesMutables: MutableList<Int> = mutableListOf(104, 105, 106)
    println("Lista mutable de IDs de pacientes: ${pacientesMutables}")

    val medicamentos = mutableListOf("Paracetamol", "Ibuprofeno")
    medicamentos.add("Amoxicilina")
    medicamentos += "Omeprazol"
    medicamentos.add(index = 1, element = "Paracetamol")
    println(medicamentos)

    medicamentos.remove(element = "Ibuprofeno")
    println(medicamentos)

    medicamentos.removeAt(index = 0)
    println(medicamentos)

    medicamentos[0] = "Azitromicina"
    println(medicamentos)

    medicamentos.clear()
    println(medicamentos.isEmpty())

    println("Búsquedas con lista mutable de pacientes")
    val nombresPacientes = mutableListOf("Isaac", "María", "Pedro")
    println(nombresPacientes.find { it.startsWith(prefix = "M") })
    println(nombresPacientes.firstOrNull { it.length > 4 })
    println(nombresPacientes.any { it.contains(char = 'a') })
    println(nombresPacientes.none { it == "X" })
}