package com.example.basics


fun mostrarMensaje() {
    println("Bienvenido al sistema de Historias Clínicas")
}

fun registrarPaciente(nombre: String, edad: Int): String {
    return "Paciente $nombre, de $edad años, registrado correctamente."
}

fun calcularIMC(peso: Double, altura: Double) = peso / (altura * altura)

fun evaluarPaciente(peso: Double, altura: Double): Pair<String, String> {
    val imc = calcularIMC(peso, altura)
    val diagnostico = when {
        imc < 18.5 -> "Bajo peso"
        imc < 24.9 -> "Normal"
        imc < 29.9 -> "Sobrepeso"
        else -> "Obesidad"
    }
    val riesgo = if (imc >= 25) "Riesgo moderado/alto" else "Riesgo bajo"
    return Pair(diagnostico, riesgo)
}

fun main() {
    mostrarMensaje()

    val registro = registrarPaciente(nombre = "Isaac Torres", edad = 32)
    println(registro)

    val imc = calcularIMC(peso = 72.0, altura = 1.75)
    println("IMC del paciente: %.2f".format(imc))

    val (diagnostico, riesgo) = evaluarPaciente(peso = 72.0, altura = 1.75)
    println("Diagnóstico: $diagnostico")
    println("Nivel de riesgo: $riesgo")

    // Expresiones Lambda
    val saludoLambda = { nombre: String -> "Bienvenido, paciente $nombre" }
    val resumenLambda = { imc: Double -> "Su IMC actual es de %.2f".format(imc) }

    println(saludoLambda("Isaac Torres"))
    println(resumenLambda(imc))
}
