package com.example.callscreentheme

import android.app.role.RoleManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.callscreentheme.databinding.ActivitySuccesssfullyBinding


class SuccesssfullyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            var binding = ActivitySuccesssfullyBinding.inflate(layoutInflater)

        binding.back.setOnClickListener {
            onBackPressed()
        }

        binding.home.setOnClickListener {
            val intent = Intent(this, ScreenThemeActivity::class.java)
            startActivity(intent)

        }
        setContentView(binding.root)
    }

}