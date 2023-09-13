package com.example.callscreentheme

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var onBoardingScreen: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var prefs = Prefs(this)
        Utils.setLocale(this, prefs.getLang())


        prefs.addLang("hi")

        // Use the correct SharedPreferences name and initialize the Editor
        onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE)
        val editor = onBoardingScreen.edit()

        val isFirstTime = onBoardingScreen.getBoolean("firstTime", true)

        Handler().postDelayed({
            if (isFirstTime) {
                // Mark the first-time flag as false
                editor.putBoolean("firstTime", false)
                editor.apply()

                startActivity(Intent(this, OnBordingActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LanguageActivity::class.java))
                finish()
            }
        }, 3000)
    }
}
