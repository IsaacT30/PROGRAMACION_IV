package com.example.basics

data class Jedi(
    val nombre: String,
    val edad: Int,
    val nivelFuerza: Int,
    val maestro: String? = null,
) {
    val rango: String
        get() = when {
            nivelFuerza >= 90 -> "maestro"
            nivelFuerza >= 70 -> "caballero"
            nivelFuerza >= 50 -> "padawan"
            else -> "Iniciado"
        }
}

fun Jedi.puedeEnsenar(): Boolean = nivelFuerza >= 5
fun Jedi.entrenar(): Boolean = edad <= 5

fun main() {
    val Luke = Jedi(
        nombre = "Anakin",
        edad = 25,
        nivelFuerza = 75,
        maestro = "Obiwam kenovi"
    )
    println(Luke)

    val (nombre, edad, nivelFuerza) = Luke
    println("Nombre Jedi ${nombre}, edad:${edad}, nivel de la fuerza:${nivelFuerza}")

    val ashoka = Luke.copy(nombre = "asoka", nivelFuerza = 80)
    println(ashoka)
}


