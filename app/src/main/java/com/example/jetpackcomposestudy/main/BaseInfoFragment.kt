package com.example.jetpackcomposestudy.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment

class BaseInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                WebPageScreen(urlToRender = "https://developer.android.google.cn/jetpack/compose/mental-model?hl=zh-cn")
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun WebPageScreen(urlToRender: String) {
        AndroidView(viewBlock = ::WebView) { webView ->
            with(webView){
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(urlToRender)
            }
        }
    }
}