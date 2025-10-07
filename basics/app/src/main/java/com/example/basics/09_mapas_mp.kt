package com.example.basics

fun main() {
    println("Mapas en Historias Clínicas")
    println("Mapas inmutables")

    val signosVitales = mapOf(
        "Isaac" to 98,
        "Alejandro" to 95,
        "Torres" to 90
    )
    println("Signos Vitales Pacientes: ${signosVitales}")

    println("Mapa mutable")

    val tratamientosCompletados = mutableMapOf<String, Int>()
    tratamientosCompletados["Isaac"] = 5
    tratamientosCompletados["Alejandro"] = 3
    tratamientosCompletados.put("Torres", 7)

    println("Tratamientos completados: ${tratamientosCompletados}")

    for ((paciente, valor) in signosVitales) {
        println("$paciente tiene un nivel de signos vitales de $valor%")
    }

    val areasVisitadas = setOf("Emergencias", "Laboratorio", "Hospitalización")
    println("Áreas visitadas: ${areasVisitadas}")

    val areasRestringidas = setOf("Quirófano", "UCI", "Laboratorio")
    println("Áreas restringidas: ${areasRestringidas}")

    println("Operaciones de conjuntos")
    val interseccion = areasVisitadas intersect areasRestringidas
    val union = areasVisitadas union areasRestringidas
    val diferencia = areasVisitadas - areasRestringidas

    println("Áreas visitadas y restringidas: ${interseccion}")
    println("Todas las áreas: ${union}")
    println("Áreas seguras visitadas: ${diferencia}")
}