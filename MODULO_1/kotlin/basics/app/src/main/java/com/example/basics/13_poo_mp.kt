package com.example.basics

data class HistoriaClinicad(
    val nombrePaciente: String,
    val edad: Int,
    val peso: Double,
    val altura: Double,
    val diagnostico: String? = null,
) {
    // Propiedad calculada: IMC (Índice de Masa Corporal)
    val imc: Double
        get() = peso / (altura * altura)

    // Propiedad calculada: clasificación según el IMC
    val clasificacionIMC: String
        get() = when {
            imc < 18.5 -> "Bajo peso"
            imc < 25 -> "Peso normal"
            imc < 30 -> "Sobrepeso"
            else -> "Obesidad"
        }
}

// Funciones de extensión
fun HistoriaClinicad.esAdulto(): Boolean = edad >= 18
fun HistoriaClinicad.requiereAtencion(): Boolean = clasificacionIMC == "Obesidad" || clasificacionIMC == "Bajo peso"

fun main() {
    val paciente1 = HistoriaClinicad(
        nombrePaciente = "Juan Torres",
        edad = 28,
        peso = 70.0,
        altura = 1.75,
        diagnostico = "Sin complicaciones"
    )
    println(paciente1)

    val (nombrePaciente, edad, peso, altura, diagnostico) = paciente1
    println("Nombre: $nombrePaciente, Edad: $edad, Peso: $peso, Altura: $altura, Diagnóstico: $diagnostico")

        val paciente2 = paciente1.copy(nombrePaciente = "Ana Cepeda", peso = 85.0, altura = 1.60)
    println(paciente2)

    println("IMC de ${paciente2.nombrePaciente}: %.2f".format(paciente2.imc))
    println("Clasificación: ${paciente2.clasificacionIMC}")

    println("¿${paciente2.nombrePaciente} es adulto?: ${paciente2.esAdulto()}")
    println("¿Requiere atención médica?: ${paciente2.requiereAtencion()}")
}

