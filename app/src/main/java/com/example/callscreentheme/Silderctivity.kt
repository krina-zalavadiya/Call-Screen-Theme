package com.example.callscreentheme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.callscreentheme.databinding.ActivitySilderactivityBinding

class Silderctivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySilderactivityBinding.inflate(layoutInflater)
        val intent = Intent(this, ScreenThemeActivity::class.java)
        startActivity(intent)
        setContentView(binding.root)
    }
}