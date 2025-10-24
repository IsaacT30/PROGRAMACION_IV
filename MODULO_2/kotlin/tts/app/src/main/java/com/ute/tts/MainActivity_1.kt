package com.ute.tts

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity_1: AppCompatActivity(), OnInitListener {
    var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_mp)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.buttonGuardar).setOnClickListener {
            var nombre = findViewById<EditText>(R.id.editTextNombre).text.toString()
            var edad = findViewById<EditText>(R.id.editTextEdad).text.toString()
            var diagnostico = findViewById<EditText>(R.id.editTextDiagnostico).text.toString()

            var texto = if (nombre.isNotEmpty() && edad.isNotEmpty() && diagnostico.isNotEmpty()) {
                "Paciente: $nombre, Edad: $edad años, Diagnóstico: $diagnostico"
            } else {
                "Por favor, completa todos los campos de la historia clínica."
            }

            Log.i("UTE_HC", texto)
            tts?.speak(texto, TextToSpeech.QUEUE_FLUSH, null, "")
        }

        tts = TextToSpeech(this, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.setLanguage(Locale("ES"))
            findViewById<TextView>(R.id.textViewTitulo).text = "Historia Clínica lista para usar"
        } else {
            findViewById<TextView>(R.id.textViewTitulo).text = "Error al inicializar TTS"
        }
        findViewById<ProgressBar>(R.id.progressBarCargando).visibility = View.GONE
    }
}