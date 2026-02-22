package com.example.basics

fun main () {
    println("Mapas")
    val inmutable: List<Int> = listOf(1, 2, 3)
    println("Lista inmutable ${inmutable}")

    val mutablelista: MutableList<Int> = mutableListOf(4, 5, 6)
    println("Lista Mutable ${mutablelista}")


    val colores= mutableListOf("Rojo","verde")
    colores.add("azul")
    colores +="amarillo"
    colores.add (index = 1 , element = "blanco")
    println(colores)
    colores.remove(element = "verde")
    println(colores)
    colores.removeAt(index = 0)
    println(colores)
    colores[0]="negro"
    println(colores)
    colores.clear()
    println(colores.isEmpty())

    println("Busquedas con mutable list")
    val nombres = mutableListOf("Juan"," Luis", "pedro")
    println(nombres.find{it.startsWith(prefix = "L")})
    println(nombres.firstOrNull{it.length>4})
    println(nombres.any{it.contains(char = 'j')})
    println(nombres.none{it=="X"})




}
