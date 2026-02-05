package com.example.basics

fun main() {
    println("Bucles")
    val jedis = listOf("luke", "leia", "Yoda")
    for ((index, jedi) in jedis.withIndex()) {
        println("${index + 1}.$jedi")
    }
    for (i in 0 .. 20 step 2){
        println("energia $i%")
    }
    // rangos descendentes
    for(countdown in 10 downTo 1 ){
        println("Despegue en: $countdown")
    }

    // control de flujo
    for ( jed in jedis){
        if(jed == "Obi-wan") continue
        if(jed == "Yoda") break
        println("entrenamiento a $jed")
    }


}