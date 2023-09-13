package com.example.callscreentheme.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentManager
import com.example.callscreentheme.Fragment.Fragment1
import com.example.callscreentheme.Fragment.Fragment2
import com.example.callscreentheme.Fragment.Fragment3
import com.example.callscreentheme.R


open class FragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Fragment1()
            }

            1 -> {
                Fragment2()
            }

            else -> {
                Fragment3()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }
}























