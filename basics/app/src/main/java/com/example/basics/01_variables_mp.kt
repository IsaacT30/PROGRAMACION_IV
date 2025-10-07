package com.example.basics

fun main(){
    println("Variables")
    val hospital = "Clínica Central"
    var medico = "Dra. Pérez"

    medico = "Dr. Gómez"

    println("Tipos de variable")
    println("Tipos de Numéricos")
    println("Tipos Entero")

    val edadPaciente: Int = 32
    println(edadPaciente)

    println("Tipo Double")
    val temperatura: Double = 36.7
    println(temperatura)

    println("Tipos Float")
    val pesoPaciente: Float = 72.5f
    println(pesoPaciente)

    println("Tipos Longitud")
    val numeroHistoria: Long = 2_000_001L
    println(numeroHistoria)

    println("Tipos Texto")
    val nombrePaciente: String = "Isaac"
    println(nombrePaciente)

    println("Tipos Char")
    val grupoSanguineo: Char = 'O'
    println(grupoSanguineo)

    println("Tipos Lógico")
    val tieneSeguro: Boolean = true
    println(tieneSeguro)

    println("Nulidad")
    val alergias: String? = null
    println(alergias)

    println("Nulidad")
    val diagnostico: String? = ""
    println(diagnostico?.length)

    println("Operación de aserción no null")
    val longitudSegura = alergias!!.length

    println("Operación de aserción no null")
    val nombreDoctor: String = "Martínez"
    val experiencia: Int = 15
    val especialidad: String = "Cardiología"

    println("El Dr. ${nombreDoctor.uppercase()} trabaja en ${especialidad}")
    println("En 10 años tendrá ${experiencia+10} años de experiencia ")

    println("String Multilínea")
    val mensaje = """
        Estimado paciente $nombrePaciente
        Su historia clínica número $numeroHistoria
        ha sido registrada correctamente 
        Gracias por confiar en $hospital
        """
    println(mensaje)

    println("Conversiones")
    val textoEdad: String = "40"
    val edadConvertida: Int = textoEdad.toInt()
    println(edadConvertida)

    val numero: Double = 120.5
    val numeroConvertido: String = numero.toString()
    println(numeroConvertido)
}
