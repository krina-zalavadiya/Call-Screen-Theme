package com.example.callscreentheme

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.callscreentheme.databinding.ActivityPremiumBinding
import com.example.callscreentheme.databinding.ActivityPremiumDialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.zip.Checksum


class premiumActivity : AppCompatActivity() {



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityPremiumBinding.inflate(layoutInflater)

        if (binding.radiopro1.isChecked){

        }
        binding.radiopro1.setOnClickListener {
            binding.radiopro1.isChecked = true
            binding.radiopro2.isChecked = false
            binding.radiopro3.isChecked = false
        }
        binding.radiopro2.setOnClickListener {
            binding.radiopro1.isChecked = false
            binding.radiopro2.isChecked = true
            binding.radiopro3.isChecked = false
        }
        binding.radiopro3.setOnClickListener {
            binding.radiopro1.isChecked = false
            binding.radiopro2.isChecked = false
            binding.radiopro3.isChecked = true
        }

        binding.close.setOnClickListener {

            val dialog = Dialog(this)
            var dilogbinding:ActivityPremiumDialogBinding = ActivityPremiumDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dilogbinding.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dilogbinding.btncontinueprrmium.setOnClickListener {
                startActivity(Intent(this,premiumActivity::class.java))
            }
            dilogbinding.close1.setOnClickListener {
                Toast.makeText(this, "Your Transaction has been Canceled", Toast.LENGTH_SHORT)
                    .show()
                dialog.dismiss()
            }
            dialog.show()
        }

        binding.btncontinue.setOnClickListener {

        }

        setContentView(binding.root)


        }




}
