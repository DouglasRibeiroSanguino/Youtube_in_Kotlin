package com.example.youtubevideo

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubevideo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView = findViewById<WebView>(R.id.webview)
        val webSettings = webView.settings

        // Habilitar a execução de JavaScript na WebView (necessário para manipulação da página)
        webSettings.javaScriptEnabled = true

        // Configurar um WebViewClient para abrir links no próprio WebView
        webView.webViewClient = WebViewClient()

        // URL de exemplo de um vídeo do YouTube (substitua pelo seu vídeo desejado)
        val videoUrl = "https://youtu.be/monf_Z2hCfo"

        // Carregar o URL de incorporação do vídeo do YouTube
        webView.loadUrl(videoUrl)

    }
}