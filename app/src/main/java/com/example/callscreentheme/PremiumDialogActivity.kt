package com.example.callscreentheme

import android.R
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.callscreentheme.databinding.ActivityPremiumDialogBinding


class PremiumDialogActivity : AppCompatActivity() {
    lateinit var context:Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding  = ActivityPremiumDialogBinding.inflate(layoutInflater)

        binding.close1.setOnClickListener {
            dismissDialog(startActivity(Intent(this,premiumActivity::class.java)))
        }
        setContentView(binding.root)

    }

    private fun dismissDialog(startActivity: Unit) {
        TODO("Not yet implemented")
    }
}