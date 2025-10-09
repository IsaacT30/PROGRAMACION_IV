package com.example.basics


fun saludar() {
    println("Hola desde una función")
}

fun sumar(a: Int, b: Int): Int {
    return a + b
}


fun cuadrado(numero: Int) = numero * numero


fun RetornoMultiple(a: Int, b: Int): Pair<Int, Int> {
    val suma = a + b
    val resta = a - b
    return Pair(suma, resta)
}


fun main() {
    saludar()

    val resultado = sumar(a = 6, b = 5)
    println(resultado)
    println(cuadrado(numero = 5))
    println(RetornoMultiple(a = 15, b=5))

    val cuadradoLambda = { x: Int -> x * x }
    val saludoLambda = { nombre: String -> "Good Morning, $nombre" }
    println(cuadradoLambda(4))
    println(saludoLambda("Juan Luis"))
}




fun bateria() {
    println("Simulación de Batería del Celular")
    for (bateria in 100 downTo 0 step 10) {
        if (bateria == 100) {
            println("Batería al $bateria%: ¡Cargado!")
        } else if (bateria == 50) {
            println("Batería al $bateria%: ¡Midas de carga!")
        } else if (bateria == 10) {
            println("Batería al $bateria%: ¡Conecte el cargador!")
        } else if (bateria == 0) {
            println("Batería al $bateria%: ¡Apagado!")
        } else {
            println("Batería al $bateria%")
        }
    }
}





