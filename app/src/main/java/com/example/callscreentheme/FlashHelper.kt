package com.example.callscreentheme

import android.content.Context
import android.hardware.Camera
import android.util.Log

object FlashHelper {
    var camera: Camera? = null
    var isFlashOn = false
    var params: Camera.Parameters? = null
    fun hasSupport(context: Context): Boolean {
        return java.lang.Boolean.valueOf(context.packageManager.hasSystemFeature("android.hardware.camera.flash"))
    }

    fun getCamera() {
        if (camera == null) {
            try {
                val open = Camera.open()
                camera = open
                params = open.parameters
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun turnOnFlash() {
        try {
            if (!isFlashOn) {
                Log.i("FlashLight", " :Flash Helper :  On")
                if (camera == null || params == null) {
                    getCamera()
                }
                val parameters = camera!!.parameters
                params = parameters
                parameters.flashMode = "torch"
                camera!!.parameters = params
                camera!!.startPreview()
                isFlashOn = true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun turnOffFlash() {
        try {
            if (isFlashOn) {
                Log.i("FlashLight", " :Flash Helper :  Off")
                if (camera == null || params == null) {
                    getCamera()
                }
                val parameters = camera!!.parameters
                params = parameters
                parameters.flashMode = "off"
                camera!!.parameters = params
                camera!!.stopPreview()
                isFlashOn = false
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun FlashOff() {
        try {
            if (camera == null || params == null) {
                getCamera()
            }
            val parameters = camera!!.parameters
            params = parameters
            parameters.flashMode = "off"
            camera!!.parameters = params
            camera!!.stopPreview()
            camera!!.release()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun destroy(context: Context?) {
        val camera2 = camera
        if (camera2 != null) {
            camera2.release()
            camera = null
        }
    }
}