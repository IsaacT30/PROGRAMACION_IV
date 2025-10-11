package com.example.basics

class PresionBajaException(message: String) : Exception(message)

class TemperaturaAltaException(message: String) : Exception(message)

fun registrarSignos(presion: Int, temperatura: Double): String {
    return try {
        when {
            presion < 90 -> throw PresionBajaException("Presión arterial muy baja: $presion mmHg")
            temperatura > 39.0 -> throw TemperaturaAltaException("Temperatura corporal alta: $temperatura °C")
            else -> "Signos vitales dentro del rango normal"
        }
    } catch (e: PresionBajaException) {
        "Error: ${e.message}. Se recomienda evaluación médica inmediata."
    } catch (e: TemperaturaAltaException) {
        "Error: ${e.message}. Posible fiebre, aplicar tratamiento."
    } catch (e: Exception) {
        "Error inesperado: ${e.message}"
    } finally {
        println("Reporte de signos vitales enviado al sistema.")
    }
}

fun main() {
    println(registrarSignos(presion = 85, temperatura = 36.8))
    println(registrarSignos(presion = 120, temperatura = 40.2))
}
