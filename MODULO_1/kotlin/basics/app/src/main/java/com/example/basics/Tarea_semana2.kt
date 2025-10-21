package com.example.basics

fun main() {

    // 1. Termostato doméstico
    val temp = 20
    val pref = "templado"
    if (pref == "frio" && temp > 22) println("Encender aire")
    else if (pref == "caliente" && temp < 18) println("Encender calefacción")
    else if (pref == "templado" && temp in 18..22) println("En confort")
    else println("Ventilar")

    // 2. Costo de envío express
    val distancia = 10.0
    val llueve = true
    var costo = if (distancia <= 5) 2.5
    else if (distancia in 6.0..15.0) 5.0
    else 8.0
    if (llueve) costo += 1.5
    println("Costo total: $costo")

    // 3. Control de acceso por horario
    val hora = 10
    val rol = "empleado"
    val acceso = if (rol == "admin") "Permitido"
    else if (rol == "invitado" && hora in 9..17) "Permitido"
    else if (rol == "empleado" && hora in 6..20) "Permitido"
    else "Denegado"
    println("Acceso: $acceso")

    // 4. Simulador de ahorro semanal
    val meta = 100
    var ahorro = 20
    var deposito = 5
    var semana = 1
    while (ahorro < meta) {
        ahorro += deposito
        println("Semana $semana: ahorro total = $ahorro")
        deposito += 10
        semana++
    }

    // 5. Detector de vocales consecutivas
    val texto = "hola que tal"
    val vocales = "aeiouAEIOU"
    var contador = 0
    for (i in 0 until texto.length - 1) {
        if (texto[i] in vocales && texto[i + 1] in vocales) contador++
    }
    println("Vocales consecutivas: $contador")

    // 6. Cuenta regresiva con eventos
    for (i in 30 downTo 0) {
        when (i) {
            20 -> println("Chequeo de sistemas")
            10 -> println("Últimos ajustes")
            0 -> println("Despegue")
            else -> println(i)
        }
    }

    // 7. Cola de supermercado
    val clientesTotales = listOf(Pair(120.0, 8), Pair(50.0, 12), Pair(200.0, 5))
    var ventaTotal = 0.0
    var cantClientes = 0
    for (cliente in clientesTotales) {
        var total = cliente.first
        val items = cliente.second
        if (total > 100) total *= 0.95
        if (items > 10) println("Caja rápida no disponible")
        ventaTotal += total
        cantClientes++
    }
    println("Clientes atendidos: $cantClientes")
    println("Venta total del día: $ventaTotal")

    // 8. ATM simplificado
    var saldo = 100.0
    val operaciones = listOf(Pair(1, 50.0), Pair(2, 30.0), Pair(2, 150.0))
    for (op in operaciones) {
        when (op.first) {
            1 -> saldo += op.second
            2 -> if (op.second <= saldo) saldo -= op.second else println("Fondos insuficientes")
        }
        println("Saldo actual: $saldo")
    }

    // 9. Generador de usuario
    val nombre = "Ana"
    val apellido = "Lopez"
    var username = ""
    var i = 0
    while (i < nombre.length || i < apellido.length) {
        if (i < nombre.length) username += nombre[i]
        if (i + 1 < nombre.length) username += nombre[i + 1]
        if (i < apellido.length) username += apellido[i]
        if (i + 1 < apellido.length) username += apellido[i + 1]
        i += 2
    }
    while (username.length < 6) username += (username.length + 1)
    println("Usuario generado: $username")

    // 10. Rally de resistencia
    var energia = 100
    val etapas = listOf(1,2,3,1,2,3,1)
    for ((index, terreno) in etapas.withIndex()) {
        energia -= when (terreno) {
            1 -> 5
            2 -> 10
            else -> 15
        }
        if (energia <= 0) {
            println("Abandona en etapa ${index + 1}")
            break
        }
    }
    if (energia > 0) println("Rally completado con energía $energia")
}
