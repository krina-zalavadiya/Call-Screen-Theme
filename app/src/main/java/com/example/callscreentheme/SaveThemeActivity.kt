package com.example.callscreentheme

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.callscreentheme.databinding.ActivitySaveThemeBinding


class SaveThemeActivity : AppCompatActivity() {
    val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySaveThemeBinding.inflate(layoutInflater)
        var theme = intent.getIntExtra("theme", 0)
        binding.imgtheme.setImageResource(theme)
        /*binding.btnsave.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom)
            binding.btncall2.startAnimation(animation)
            binding.btncall1.startAnimation(animation)

              val animation1 = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom)
            binding.btncall2.startAnimation(animation1)
            binding.btncall1.startAnimation(animation1)
*/
        binding.btnsavetheme.setOnClickListener {
        val intent = Intent(this, SaveCallThemeActivity::class.java)
        startActivity(intent)
        }
        setContentView(binding.root)
    }
    /*binding.premium.setOnClickListener {
            val intent = Intent(this, premiumActivity::class.java)
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            onBackPressed()
        }*/




}


