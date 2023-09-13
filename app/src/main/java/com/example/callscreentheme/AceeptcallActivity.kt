package com.example.callscreentheme

import android.app.Activity
import android.app.KeyguardManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.KeyEvent
import android.view.WindowManager
import java.io.IOException
import java.util.logging.Logger

class AceeptcallActivity : Activity() {
    private var keyguardManager: KeyguardManager? = null
    private var audioManager: AudioManager? = null
    private var callStateReceiver: CallStateReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        keyguardManager = getSystemService(KEYGUARD_SERVICE) as KeyguardManager
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
    }

    override fun onResume() {
        super.onResume()
        registerCallStateReceiver()
        updateWindowFlags()
        acceptCall()
    }

    override fun onPause() {
        super.onPause()
        if (callStateReceiver != null) {
            unregisterReceiver(callStateReceiver)
            callStateReceiver = null
        }
    }

    private fun registerCallStateReceiver() {
        callStateReceiver = CallStateReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED)
        registerReceiver(callStateReceiver, intentFilter)
    }

    private fun updateWindowFlags() {
        if (keyguardManager!!.inKeyguardRestrictedInputMode()) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        }
    }

    private fun acceptCall() {
        val broadcastConnected = MANUFACTURER_HTC.equals(
            Build.MANUFACTURER,
            ignoreCase = true
        ) && !audioManager!!.isWiredHeadsetOn
        if (broadcastConnected) {
            broadcastHeadsetConnected(false)
        }
        try {
            try {
                Runtime.getRuntime()
                    .exec("input keyevent " + Integer.toString(KeyEvent.KEYCODE_HEADSETHOOK))
            } catch (e: IOException) {
                val enforcedPerm = "android.permission.CALL_PRIVILEGED"
                val btnDown = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
                    Intent.EXTRA_KEY_EVENT, KeyEvent(
                        KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK
                    )
                )
                val btnUp = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
                    Intent.EXTRA_KEY_EVENT, KeyEvent(
                        KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK
                    )
                )
                sendOrderedBroadcast(btnDown, enforcedPerm)
                sendOrderedBroadcast(btnUp, enforcedPerm)
            }
        } finally {
            if (broadcastConnected) {
                broadcastHeadsetConnected(false)
            }
        }
    }

    private fun broadcastHeadsetConnected(connected: Boolean) {
        val i = Intent(Intent.ACTION_HEADSET_PLUG)
        i.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY)
        i.putExtra("state", if (connected) 1 else 0)
        i.putExtra("name", "mysms")
        try {
            sendOrderedBroadcast(i, null)
        } catch (e: Exception) {
        }
    }

    private inner class CallStateReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            finish()
        }
    }

    companion object {
        private val logger = Logger.getLogger(
            AceeptcallActivity::class.java.toString()
        )
        private const val MANUFACTURER_HTC = "HTC"
    }
}