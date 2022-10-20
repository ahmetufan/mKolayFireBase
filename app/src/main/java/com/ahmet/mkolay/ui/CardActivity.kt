package com.ahmet.mkolay.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.ahmet.mkolay.R
import com.ahmet.mkolay.databinding.ActivityAlisverisBinding
import com.ahmet.mkolay.databinding.ActivityCardBinding
import com.ahmet.mkolay.databinding.ActivitySepetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardBinding


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        webViewSetup()


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        binding.webView.webViewClient= WebViewClient()

        binding.webView.apply {
            loadUrl("https://api-test.moneypay.com.tr:8743/#/list?userToken=73786f6d6b6e4f636f6c6e726c757371")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }
}