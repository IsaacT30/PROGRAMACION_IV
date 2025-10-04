package com.example.basics

fun main() {
    println("Operadores Aritméticos")
    println("Condicionales")

    val value1 = 18
    val value2 = 15

    if (value1 > value2) {
        println("El mayor es ${value1}")
    } else {
        println("El mayor es ${value2}")
    }

    fun main() {
        println("Rango según nivel de fuerza")

        val fuerza: Int = 10

        if (fuerza > 10) {
            println("maestro")
        } else if (fuerza > 5) {
            println("caballero jedi")
        } else {
            println("padawan")
        }

        var tipoDroide: String = ""
        when(tipoDroide){
            "R2-D2", "R2-Q5"->print("Droide astromecanico")
            "C-3PO", "C-3PA"->print("Droide protocolo")
            "BB8-8", "BB-9F"->print("Droide de nueva generacion")
            else -> print("Modelo Desconocido")
        }

        var peligro: Int = 5
        var recompensa: Int = 5
        when{
            peligro>8 && recompensa<100 ->print("Mision Rechazada")
            peligro<=3 ->print("Mision Aceptada")
            else -> print("Requiere evaluacion adicional")
        }

        val verde = "Verde"
        val trafico = "Trafico"
        when {
            verde == "rojo" -> print("esperar")
            verde == "amarillo" -> print("precaución")
            verde == "verde" -> print(if (trafico == "vacia") "avanzar (precaución)" else "avanzar (mantener)")
            else -> print("Error")
        }

        fun main() {
            println("Detector de Elemento Zodiacal")
            print("Ingresa tu mes de nacimiento (1-12): ")
            val mes = 5

            when (mes) {
                3, 4, 7, 8, 11, 12 -> print("Elemento de Fuego (Aries, Leo, Sagitario)")
                4, 5, 8, 9, 12, 1 -> print("Elemento de Tierra (Tauro, Virgo, Capricornio)")
                5, 6, 9, 10, 1, 2 -> print("Elemento de Aire (Géminis, Libra, Acuario)")
                6, 7, 10, 11, 2, 3 -> print("Elemento de Agua (Cáncer, Escorpio, Piscis)")
                else -> print("Mes inválido. Ingresa un número del 1 al 12.")
            }
        }




    }
}

