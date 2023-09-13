package com.example.callscreentheme

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.callscreentheme.LocalHelper.setlocale
import com.example.callscreentheme.databinding.ActivityLanguageBinding
import java.util.Locale
import android.content.Context as Context1


class LanguageActivity : AppCompatActivity() {

    lateinit var prefs: Prefs
    lateinit var context: Context1
    var language = ""
    var text: String? = null
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = Prefs(this)
        Utils.setLocale(this, prefs.getLang())
        var Binding = ActivityLanguageBinding.inflate(layoutInflater)

        var int = 1


        Binding.card1.setOnClickListener {
            Binding.real1.setBackgroundResource(R.drawable.bgbtn)
            Binding.real2.setBackgroundResource(R.color.blacklight)
            Binding.real3.setBackgroundResource(R.color.blacklight)
            Binding.real4.setBackgroundResource(R.color.blacklight)
            Binding.real5.setBackgroundResource(R.color.blacklight)
            Binding.real6.setBackgroundResource(R.color.blacklight)
            setlanguage("en")
            // Save the selected language preference
            prefs.addLang("en")
            prefs.getLang()
            Binding.textlanguage1.setText(R.string.Language)
            setlocale(this, "en")
            context = LocalHelper.setlocale(applicationContext, "en")
            startActivity(Intent(this,OnBordingActivity::class.java))
        }
        Binding.card2.setOnClickListener {
            Binding.real1.setBackgroundResource(R.color.blacklight)
            Binding.real2.setBackgroundResource(R.drawable.bgbtn)
            Binding.real3.setBackgroundResource(R.color.blacklight)
            Binding.real4.setBackgroundResource(R.color.blacklight)
            Binding.real5.setBackgroundResource(R.color.blacklight)
            Binding.real6.setBackgroundResource(R.color.blacklight)
            setlanguage("es")
            // Save the selected language preference
            prefs.addLang("es")
            prefs.getLang()
            Binding.textlanguage2.setText(R.string.Language)
            setlocale(this, "es")
            context = LocalHelper.setlocale(applicationContext, "es")
            startActivity(Intent(this,OnBordingActivity::class.java))

        }

        Binding.card3.setOnClickListener {
            Binding.real1.setBackgroundResource(R.color.blacklight)
            Binding.real2.setBackgroundResource(R.color.blacklight)
            Binding.real3.setBackgroundResource(R.drawable.bgbtn)
            Binding.real4.setBackgroundResource(R.color.blacklight)
            Binding.real5.setBackgroundResource(R.color.blacklight)
            Binding.real6.setBackgroundResource(R.color.blacklight)
            startActivity(Intent(this,OnBordingActivity::class.java))
            setlanguage("fr")
            // Save the selected language preference
            prefs.addLang("fr")
            prefs.getLang()
            Binding.textlanguage3.setText(R.string.Language)
            setlocale(this, "fr")
            context = LocalHelper.setlocale(applicationContext, "fr")
        }
        Binding.card4.setOnClickListener {
            Binding.real1.setBackgroundResource(R.color.blacklight)
            Binding.real2.setBackgroundResource(R.color.blacklight)
            Binding.real3.setBackgroundResource(R.color.blacklight)
            Binding.real4.setBackgroundResource(R.drawable.bgbtn)
            Binding.real5.setBackgroundResource(R.color.blacklight)
            Binding.real6.setBackgroundResource(R.color.blacklight)

            setlanguage("hi")
            // Save the selected language preference
            prefs.addLang("hi")
            prefs.getLang()
            Binding.textlanguage4.setText(R.string.Language)
            setlocale(this, "hi")
            context = LocalHelper.setlocale(applicationContext, "hi")
            startActivity(Intent(this,OnBordingActivity::class.java))

        }
        Binding.card5.setOnClickListener {
            Binding.real1.setBackgroundResource(R.color.blacklight)
            Binding.real2.setBackgroundResource(R.color.blacklight)
            Binding.real3.setBackgroundResource(R.color.blacklight)
            Binding.real4.setBackgroundResource(R.color.blacklight)
            Binding.real5.setBackgroundResource(R.drawable.bgbtn)
            Binding.real6.setBackgroundResource(R.color.blacklight)

            startActivity(Intent(this,OnBordingActivity::class.java))

            setlanguage("pt")
            // Save the selected language preference
            prefs.addLang("pt")
            prefs.getLang()
            Binding.textlanguage5.setText(R.string.Language)
            setlocale(this, "pt")
            context = LocalHelper.setlocale(applicationContext, "pt")

        }
        Binding.card6.setOnClickListener {
            Binding.real1.setBackgroundResource(R.color.blacklight)
            Binding.real2.setBackgroundResource(R.color.blacklight)
            Binding.real3.setBackgroundResource(R.color.blacklight)
            Binding.real4.setBackgroundResource(R.color.blacklight)
            Binding.real5.setBackgroundResource(R.color.blacklight)
            Binding.real6.setBackgroundResource(R.drawable.bgbtn)
            startActivity(Intent(this,OnBordingActivity::class.java))

            setlanguage("ru")
            // Save the selected language preference
            prefs.addLang("ru")
            prefs.getLang()
            Binding.textlanguage6.setText(R.string.Language)
            setlocale(this, "ru")
            context = LocalHelper.setlocale(applicationContext, "ru")
        }

        Binding.languagearrow1.setOnClickListener {
            Binding.textlanguage1.setText("English")
            Binding.textlanguage2.setText("Spanish")
            Binding.textlanguage3.setText("French")
            Binding.textlanguage4.setText("Hindi")
            Binding.textlanguage5.setText("Portuguese")
            Binding.textlanguage6.setText("Russian")

            startActivity(Intent(this, OnBordingActivity::class.java))
        }

        setContentView(Binding.root)

    }

    fun setlanguage(language: String) {
        var loacale = Locale(language)
        Locale.setDefault(loacale)
        val resources: Resources = this.getResources()
        val configuration = resources.configuration
        configuration.locale = loacale
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    fun setAppLocale(context: Context1, language: String) {
        val selectedLanguage = ""
        // For example: Prefs(this).getLang()

            // Set the app's locale based on the selected language
        LocalHelper.setLocale(this, selectedLanguage)
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }


}

private fun TextView.setText(setlanguage: Unit) {
    TODO("Not yet implemented")
}

