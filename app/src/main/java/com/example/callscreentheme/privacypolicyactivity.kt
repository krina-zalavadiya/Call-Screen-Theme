package com.example.callscreentheme

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class privacypolicyactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacypolicyactivity)
       var  web =findViewById<WebView>(R.id.webView);
        web.loadUrl("https://gotiinfoways.blogspot.com/2023/09/privacy-policy_12.html");
    }
}