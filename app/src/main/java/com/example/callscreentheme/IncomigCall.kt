package com.example.callscreentheme

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.telephony.TelephonyManager
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView


class IncomingCall : BroadcastReceiver() {

    private var windowManager: WindowManager? = null


    private var windowLayout: ViewGroup? = null

    private val WINDOW_WIDTH_RATIO = 0.8f
    private var params: WindowManager.LayoutParams? = null
    private var x = 0f
    private var y = 0f
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent!!.getAction().equals("android.intent.action.PHONE_STATE")) {
            val number: String = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)!!
            if (number != null) {
                if (intent.getStringExtra(TelephonyManager.EXTRA_STATE)
                        .equals(TelephonyManager.EXTRA_STATE_RINGING)
                ) {
                    showWindow(context!!, number)
                } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE)
                        .equals(TelephonyManager.EXTRA_STATE_IDLE) ||
                    intent.getStringExtra(TelephonyManager.EXTRA_STATE)
                        .equals(TelephonyManager.EXTRA_STATE_OFFHOOK)
                ) {
                    closeWindow()
                }
            }
        }
    }

    private fun showWindow(context: Context, phone: String) {
        windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowLayout = View.inflate(context, R.layout.window_call_info, null) as ViewGroup
        getLayoutParams()
//        setOnTouchListener()
//        val numberTextView = windowLayout!!.findViewById<TextView>(R.id.number)
//        numberTextView.text = phone
//        val cancelButton = windowLayout!!.findViewById<Button>(R.id.callReject
//        )
//        cancelButton.setOnClickListener { view: View? -> closeWindow() }
//        windowManager!!.addView(windowLayout, params)


    }

    private fun getLayoutParams() {
        params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            getWindowsTypeParameter(),
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON or
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            PixelFormat.TRANSLUCENT
        )
        params!!.gravity = Gravity.CENTER
        params!!.format = 1
        params!!.width = getWindowWidth()
    }

    private fun getWindowsTypeParameter(): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else WindowManager.LayoutParams.TYPE_PHONE
    }

    private fun getWindowWidth(): Int {
        val metrics = DisplayMetrics()
        windowManager!!.defaultDisplay.getMetrics(metrics)
        return (WINDOW_WIDTH_RATIO * metrics.widthPixels.toDouble()).toInt()
    }

    private fun setOnTouchListener() {
        windowLayout!!.setOnTouchListener { view: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    x = event.rawX
                    y = event.rawY
                }

                MotionEvent.ACTION_MOVE -> updateWindowLayoutParams(event)
                MotionEvent.ACTION_UP -> view.performClick()
                else -> {}
            }
            false
        }
    }

    private fun updateWindowLayoutParams(event: MotionEvent) {
        params!!.x = params!!.x - (x - event.rawX).toInt()
        params!!.y = params!!.y - (y - event.rawY).toInt()
        windowManager!!.updateViewLayout(windowLayout, params)
        x = event.rawX
        y = event.rawY
    }

    private fun closeWindow() {
        if (windowLayout != null) {
            windowManager!!.removeView(windowLayout)
            windowLayout = null
        }
    }
}