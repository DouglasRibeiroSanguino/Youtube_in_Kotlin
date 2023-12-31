package com.example.youtubevideo

import android.content.res.Configuration
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

        if (savedInstanceState == null) {
            // Carregar a página somente se a atividade for criada pela primeira vez
            webView()
        }
    }

    private fun webView() {
        val webView = findViewById<WebView>(R.id.webview)
        val webSettings = webView.settings

        // Habilitar a execução de JavaScript na WebView (necessário para manipulação da página)
        webSettings.javaScriptEnabled = true

        // Configurar um WebViewClient para abrir links no próprio WebView
        webView.webViewClient = WebViewClient()

        val videoUrl = "https://youtu.be/monf_Z2hCfo"
        webView.loadUrl(videoUrl)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Lide com a mudança de orientação da tela aqui (se necessário)
        // Por padrão, o Android não recarregará a WebView
    }
}