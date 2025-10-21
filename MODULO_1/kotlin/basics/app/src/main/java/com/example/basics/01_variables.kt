package com.example.basics

fun main(){
    println("Variables")
    val planeta = "Tatooine"
    var jedi = "Anakin"

    jedi = "Obiwan"

    println("Tipos de variable")
    println("Tipos de Numericos")
    println("Tipos Entero")

    val edad: Int = 25
    println(edad)

    println("Tipo Double")
    val altura: Double = 25.5
    println(altura)

    println("Tipos Float")
    val peso: Float = 25.5f
    println(peso)


    println("Tipos Longitud")
    val poblacion: Long = 2_000_000L
    println(poblacion)

    println("Tipos Texto")
    val nombre: String = "Isaac"
    println(nombre)

    println("Tipos Char")
    val inicial: Char = '0'
    println(inicial)

    println("Tipos Logico")
    val esJedi: Boolean = true
    println(esJedi)

    println("Nulidad")
    val Apellido: String? = null
    println(Apellido)

    println("Nulidad")
    val ciudad: String? = ""
    println(ciudad?.length)

    println("Operacion de asercion no null")
    val longitudSegura = Apellido!!.length

    println("Operacion de asercion no null")
    val nombrePrincesa: String = "Lela"
    val edadPrincesa: Int = 19
    val planetaPrincesa: String="Alderan"

    println("${nombrePrincesa.uppercase()} nacio en ${planetaPrincesa}")
    println("En 10 años tendra  ${edadPrincesa+10} anios ")


    println("String Multilinea")
    val mensaje = """
        Querido $nombre
        Tu mison en $planeta
        ha sido completada exitosamente 
        Que la fuerza te acompañe 
        """
    println(mensaje)

    println("Conversaciones")
    val textoEdad: String= "25"
    val edadConvertida: Int = textoEdad.toInt()
    println(edadConvertida)


    val numero: Double= 50.8
    val numeroConvertido: String = numero.toString()
    println(numeroConvertido)


}