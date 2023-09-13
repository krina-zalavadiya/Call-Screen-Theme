package com.example.callscreentheme

import android.app.role.RoleManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.callscreentheme.databinding.ActivitySaveCallThemeBinding


class SaveCallThemeActivity : AppCompatActivity() {
    private lateinit var uri:Uri
    lateinit var context: Context
    lateinit var download: MediaStore.Downloads
    var from = 0
    companion object{
    var call = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivitySaveCallThemeBinding.inflate(layoutInflater)


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);

        val win: Window = window
        win.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
        )
        win.addFlags(
            (WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        )
        win.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)


        binding.btnsave.setOnClickListener {
            requestRole()

         /*
            val intent = Intent(this, CallScreeningActivity::class.java)
            startActivity(intent)
        */

        }


        binding.back.setOnClickListener {
            onBackPressed()
        }


        binding.premium.setOnClickListener {
            val intent = Intent(this, premiumActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
    fun acceptCall() {
        val context: Context? = null
        if (Build.VERSION.SDK_INT >= 21) {
            val answerCalintent = Intent(context, AceeptcallActivity::class.java)
            answerCalintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
            answerCalintent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context!!.startActivity(answerCalintent)
        } else {
            val intent = Intent(context, AceeptcallActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context!!.startActivity(intent)
        }
    }

    fun requestRole() {
        val roleManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            getSystemService(ROLE_SERVICE) as RoleManager
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
        val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            roleManager.createRequestRoleIntent(RoleManager.ROLE_CALL_SCREENING)
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
        val REQUEST_ID = 1
        startActivityForResult(intent, REQUEST_ID)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Your app is now the call screening app
            } else {
                // Your app is not the call screening app
            }
        }
    }

}







