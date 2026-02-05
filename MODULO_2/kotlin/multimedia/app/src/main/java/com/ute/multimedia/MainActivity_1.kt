package com.ute.multimedia // <<< FIX: Changed to match build.gradle.kts namespace

import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
// If your IDE doesn't add it, you may need: import com.ute.multimedia.R

class MainActivity_1 : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mp) // Asegúrate de que este archivo XML esté en res/layout/

        // Configurar WebView para el video educativo
        webView = findViewById(R.id.webViewYouTube) // El ID debe coincidir con el XML
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.mediaPlaybackRequiresUserGesture = false // Permitir la reproducción de videos sin interacción

        webView.webChromeClient = WebChromeClient() // Manejo de la interfaz de Chrome
        webView.webViewClient = WebViewClient() // Evitar que se abran enlaces en el navegador

        // Cargar el video educativo de YouTube
        val videoEducativoUrl = "https://www.youtube.com/embed/VIDEO_CLINICO?rel=0&showinfo=0"
        webView.loadUrl(videoEducativoUrl)

        // Configurar VideoView para reproducir el video local desde la carpeta raw
        videoView = findViewById(R.id.videoViewMp4) // El ID debe coincidir con el XML
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView) // Vincula el control de medios al VideoView
        videoView.setMediaController(mediaController)

        // Establecer la URI del video desde la carpeta raw (asegúrate de que el archivo demo.mp4 esté presente)
        val videoUri: Uri = Uri.parse("android.resource://${packageName}/raw/demo")  // Reemplaza "demo" por el nombre de tu archivo MP4
        videoView.setVideoURI(videoUri)

        // Iniciar el video una vez que se haya cargado
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = false // No hacer loop en el video
            videoView.start() // Comenzar la reproducción
        }
    }

    // Permitir navegación atrás en WebView
    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}