package com.example.callscreentheme

import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.callscreentheme.Adapter.FragmentPagerAdapter
import java.util.Locale


class OnBordingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_bording)

        var viewPager = findViewById<ViewPager>(R.id.onbordingviewpager)
        var adapter = FragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter


    }

}