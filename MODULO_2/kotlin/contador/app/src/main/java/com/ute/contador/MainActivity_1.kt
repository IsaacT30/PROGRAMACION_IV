package com.ute.historiasclinicas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {

    private var pacientesAtendidos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_mp)

        val textView = findViewById<TextView>(R.id.textViewContador)
        val btnAgregar = findViewById<Button>(R.id.btnSumar)
        val btnQuitar = findViewById<Button>(R.id.btnRestar)
        val btnReset = findViewById<Button>(R.id.btnReset)

        fun actualizarTexto() {
            textView.text = pacientesAtendidos.toString()
        }

        btnAgregar.setOnClickListener {
            pacientesAtendidos++
            actualizarTexto()
        }

        btnQuitar.setOnClickListener {
            if (pacientesAtendidos > 0) pacientesAtendidos--
            actualizarTexto()
        }

        btnReset.setOnClickListener {
            pacientesAtendidos = 0
            actualizarTexto()
        }

        actualizarTexto()
    }
}