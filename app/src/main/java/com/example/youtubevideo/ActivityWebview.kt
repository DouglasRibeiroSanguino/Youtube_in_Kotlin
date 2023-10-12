package com.example.youtubevideo

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubevideo.databinding.ActivityWebviewBinding
import com.google.android.material.appbar.MaterialToolbar

class ActivityWebview : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // Carregar a página somente se a atividade for criada pela primeira vez
            webView()
        }

        toolbar()
    }

    private fun toolbar() {
        binding.toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

        val toolbarRefresh = binding.refresh

        toolbarRefresh.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.rotate_refresh)
            toolbarRefresh.startAnimation(animation)

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

        val webViewUrl = "https://mega.nz/login"
        webView.loadUrl(webViewUrl)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Lide com a mudança de orientação da tela aqui (se necessário)
        // Por padrão, o Android não recarregará a WebView
    }
}
