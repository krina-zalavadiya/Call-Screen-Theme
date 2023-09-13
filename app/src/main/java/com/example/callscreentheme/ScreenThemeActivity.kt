package com.example.callscreentheme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.callscreentheme.Fragment.DiythemeFragment
import com.example.callscreentheme.Fragment.MyDesignFragment
import com.example.callscreentheme.Fragment.ScreenThemeFragment
import com.example.callscreentheme.Fragment.SetingFragment
import com.example.callscreentheme.databinding.ActivityScreenThemeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ScreenThemeActivity : AppCompatActivity() {
    lateinit var binding: ActivityScreenThemeBinding
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pushFragment(ScreenThemeFragment())
        binding.bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                selectFragment(item)
                return true
            }
        })
    }
    protected fun selectFragment(item: MenuItem){
        item.isChecked = true
        when(item.itemId){
            R.id.Screen_theme ->
                pushFragment(ScreenThemeFragment())
            R.id.Diy_theme ->
                pushFragment(DiythemeFragment())
            R.id.My_design ->
                pushFragment(MyDesignFragment())
            R.id.setting ->
                pushFragment(SetingFragment())
            else ->
                pushFragment(ScreenThemeFragment())

        }
    }
    private fun pushFragment(fragment: Fragment?) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragframe,fragment!!)
        transaction.commit()
    }

}