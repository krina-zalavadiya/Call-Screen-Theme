package com.example.callscreentheme

import android.app.Activity
import android.content.res.Configuration
import java.util.Locale

class Utils {

    companion object {

        fun setLocale(activity: Activity, languageCode: String?) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val resources = activity.resources
            val config: Configuration = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }

}