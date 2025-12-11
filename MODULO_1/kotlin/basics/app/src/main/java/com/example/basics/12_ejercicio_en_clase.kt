package com.example.basics

fun main() {
    println("Simulación de Batería del Celular")
    for (bateria in 100 downTo 0 step 10) {
        if (bateria == 100) {
            println("Batería al $bateria%: ¡Cargado!")
        } else if (bateria == 50) {
            println("Batería al $bateria%: ¡Midad de carga!")
        } else if (bateria == 10) {
            println("Batería al $bateria%: ¡Conecte el cargador!")
        } else if (bateria == 0) {
            println("Batería al $bateria%: ¡Apagado!")
        } else {
            println("Batería al $bateria%")
        }
    }
}