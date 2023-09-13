package com.example.callscreentheme

import android.app.role.RoleManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.callscreentheme.databinding.ActivityCallScreeningBinding


class CallScreeningActivity : AppCompatActivity() {

    var REQUEST_ID = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityCallScreeningBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnsavee.setOnClickListener {
            requestRole()
        }

    }

    fun requestRole() {
        val roleManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            getSystemService(ROLE_SERVICE) as RoleManager
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
        val intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_CALL_SCREENING)
        startActivityForResult(intent, REQUEST_ID)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ID) {
            if (resultCode == RESULT_OK) {
                // Your app is now the call screening app
            } else {
                // Your app is not the call screening app
            }
        }
    }


}