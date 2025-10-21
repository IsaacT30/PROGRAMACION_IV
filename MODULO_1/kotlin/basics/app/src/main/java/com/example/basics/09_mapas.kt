package com.example.basics

fun main (){
    println("Mapas")
    println("MPas inmutables")

    val fuerzaJedis = mapOf(
        "luke" to 85,
        "Leila" to 80,
        "Yoda" to 100
    )
    println("Fuerza Jedis: ${fuerzaJedis}")
    println("Moa mutabe")

    val misionescompletadas= mutableMapOf<String,Int>()
    misionescompletadas ["LUKE"] = 15
    misionescompletadas ["Lia"] = 10
    misionescompletadas.put("nan", 20)

    println("Misiones: ${misionescompletadas}")

    for ((jedi, fuerza) in fuerzaJedis){
        println("$jedi tiene nivel de fuerza $fuerza")
    }

    val palnetasvisitados = setOf(" Tatooine", "Coruscant", "Dago")
    println("Planetas Visitados: ${palnetasvisitados}")

    val palnetaspeligrosos = setOf(" San Roque", "Marin", "Dos puentes")
    println("Planetas Peligrosos: ${palnetaspeligrosos}")

    println("Operaciones de conjuntos")
    val interseccion = palnetaspeligrosos intersect palnetasvisitados
    val union = palnetaspeligrosos - palnetasvisitados
    val diferencia = palnetaspeligrosos - palnetasvisitados

    println("Planetas Peligrosos y visitados : ${interseccion}")
    println("Todos los planetas: ${union}")
    println("Planetas Seguros visitados: ${diferencia}")





}