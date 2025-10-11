package com.example.basics

// Enumeración de tipos de diagnóstico
enum class TipoDiagnostico(val gravedad: String, val prioridad: Int) {
    LEVE("leve", 60) {
        override fun descripcion() = "El paciente presenta síntomas leves."
    },
    MODERADO("moderado", 75) {
        override fun descripcion() = "El paciente requiere observación y tratamiento básico."
    },
    GRAVE("grave", 90) {
        override fun descripcion() = "El paciente necesita atención médica urgente."
    },
    CRITICO("crítico", 100) {
        override fun descripcion() = "El paciente se encuentra en estado crítico, requiere hospitalización inmediata."
    };

    abstract fun descripcion(): String

    companion object {
        fun porGravedad(gravedad: String) = values().find { it.gravedad == gravedad }
    }
}

// Clase principal que representa la historia clínica del paciente
class HistoriaClinica(val tipo: TipoDiagnostico, val nombrePaciente: String) {

    fun registrar(): String = "📋 Registro completado: Paciente $nombrePaciente - Diagnóstico ${tipo.gravedad.uppercase()}"

    fun info(): String = "${tipo.descripcion()} - Nivel: ${tipo.name}, Prioridad médica: ${tipo.prioridad}"
}

// Función principal
fun main() {
    val historia1 = HistoriaClinica(TipoDiagnostico.MODERADO, nombrePaciente = "Carlos Pérez")
    println(historia1)
    println(historia1.registrar())
    println(historia1.info())

    val historia2 = HistoriaClinica(TipoDiagnostico.CRITICO, nombrePaciente = "Ana López")
    println(historia2)
    println(historia2.registrar())
    println(historia2.info())
}
