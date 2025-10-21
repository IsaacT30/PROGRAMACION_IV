package com.example.basics

fun main() {

    // Ejercicio 1

    println("Semáforo peatonal")
    print("Color del semáforo (rojo, amarillo, verde): ")
    val color = readLine()?.lowercase() ?: ""
    print("¿El peatón presionó el botón? (si/no): ")
    val boton = readLine()?.lowercase() ?: ""

    if (color == "verde" && boton == "si") {
        println("Espera a rojo")
    } else if (color == "rojo") {
        println("Cruza")
    } else if (color == "amarillo") {
        println("Prepárate")
    } else {
        println("Espera")
    }

    // Ejercicio 2

    println("Entrada de cine")
    print("Ingresa tu edad: ")
    val edad = readLine()?.toIntOrNull() ?: 0
    val precio = if (edad < 12) 3 else if (edad >= 65) 4 else 5
    println("Precio de entrada: $$precio")

    // Ejercicio 3

    println("Contador de pares hasta N")
    print("Ingresa N: ")
    val n1 = readLine()?.toIntOrNull() ?: 0
    var contadorPares = 0
    for (i in 1..n1) {
        if (i % 2 == 0) contadorPares++
    }
    println("Cantidad de números pares: $contadorPares")

    // Ejercicio 4

    println("Suma de múltiplos de 3")
    print("Ingresa N: ")
    val n2 = readLine()?.toIntOrNull() ?: 0
    var suma = 0
    for (i in 1..n2) {
        if (i % 3 == 0) suma += i
    }
    println("Suma de múltiplos de 3: $suma")

    // Ejercicio 5

    println("Estado del agua")
    print("Temperatura en °C: ")
    val temp = readLine()?.toIntOrNull() ?: 0
    if (temp <= 0) {
        println("Sólido")
    } else if (temp in 1..99) {
        println("Líquido")
    } else {
        println("Gas")
    }

    // Ejercicio 6

    var opcion: Int
    do {
        println("Calculadora mínima")
        println("1) Sumar")
        println("2) Restar")
        println("3) Salir")
        print("Elige una opción: ")
        opcion = readLine()?.toIntOrNull() ?: 0

        if (opcion == 1 || opcion == 2) {
            print("Primer número: ")
            val a = readLine()?.toDoubleOrNull() ?: 0.0
            print("Segundo número: ")
            val b = readLine()?.toDoubleOrNull() ?: 0.0
            if (opcion == 1) println("Resultado: ${a + b}")
            if (opcion == 2) println("Resultado: ${a - b}")
        }
    } while (opcion != 3)

    // Ejercicio 7

    println("Validador de contraseña")
    print("Ingresa contraseña: ")
    val pass = readLine() ?: ""
    val valida = pass.length >= 8 && pass.any { it.isDigit() }
    if (valida) println("Contraseña válida") else println("Contraseña inválida")

    // Ejercicio 8

    println("Contar vocales en palabra")
    print("Ingresa texto: ")
    val texto = readLine()?.lowercase() ?: ""
    var contar = 0
    for (letra in texto) {
        if (letra in listOf('a', 'e', 'i', 'o', 'u')) contar++
    }
    println("Cantidad de vocales: $contar")

    // Ejercicio 9

    println("Tabla de multiplicar")
    print("Ingresa número: ")
    val num = readLine()?.toIntOrNull() ?: 0
    for (i in 1..10) {
        println("$num x $i = ${num * i}")
    }

    // Ejercicio 10

    println("Promedio y aprobación")
    print("Nota 1: ")
    val nA = readLine()?.toDoubleOrNull() ?: 0.0
    print("Nota 2: ")
    val nB = readLine()?.toDoubleOrNull() ?: 0.0
    print("Nota 3: ")
    val nC = readLine()?.toDoubleOrNull() ?: 0.0
    val promedio = (nA + nB + nC) / 3
    println("Promedio: $promedio")
    if (promedio >= 14) println("Aprobado") else println("Reprobado")
}


