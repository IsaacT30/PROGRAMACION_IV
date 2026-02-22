package com.example.basics

enum class TipoSable(val color: String, val poder: Int) {
    AZUL("azul", 85) {
        override fun descripcion() = "Sable tradicional"
    },
    VERDE("verde", 90) {
        override fun descripcion() = "Sable"
    },
    ROJO("rojo", 95) {
        override fun descripcion() = "Sable de los Sith"
    },
    MORADO("morado", 90) {
        override fun descripcion() = "Sable que equilibra la luz"
    };

    abstract fun descripcion(): String

    companion object {
        fun porColor(color: String)= values().find {it.color==color}
    }
}
class SableDeLuz(val tipo: TipoSable, val portador: String) {

    fun activar(): String = "¡ZZZrun! El sable color ${tipo.color} de $portador se enciende"

    fun info(): String = "${tipo.descripcion()} - Tipo: ${tipo.name}, Poder: ${tipo.poder}"
}

fun main() {
    val sableWindoo = SableDeLuz(TipoSable.MORADO, portador = "Windoo")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())

    val sableLuke = SableDeLuz(TipoSable.VERDE, portador = "Luke Skywalker")
    println(sableLuke)
    println(sableLuke.activar())
    println(sableLuke.info())
}
