package com.example.basics

class FuerzaInsuficienteException(message: String) : Exception(message)

class MisionPeligrosaException(message: String) : Exception(message)

fun realizarMision(nivelFuerza: Int, peligroMision: Int): String {
    return try {
        when {
            nivelFuerza < 30 -> throw FuerzaInsuficienteException("Nivel de fuerza muy bajo: $nivelFuerza")
            nivelFuerza > 80 -> throw MisionPeligrosaException("Misión extremadamente peligrosa")
            else -> "Misión realizada con éxito"
        }
    } catch (e: FuerzaInsuficienteException) {
        "Error: ${e.message}. Se requiere entrenamiento adicional."
    } catch (e: MisionPeligrosaException) {
        "Error: ${e.message}. Nivel de peligro $peligroMision."
    } catch (e: Exception) {
        "Error inesperado: ${e.message}"
    } finally {
        println("Reporte enviado")
    }

    fun main() {
        println(realizarMision(nivelFuerza = 20, peligroMision = 60))
        println(realizarMision(nivelFuerza = 100, peligroMision = 60))
    }

}