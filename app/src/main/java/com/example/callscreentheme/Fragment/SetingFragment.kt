package com.example.callscreentheme.Fragment

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.example.callscreentheme.LanguageActivity
import com.example.callscreentheme.databinding.FragmentSetingBinding
import com.example.callscreentheme.premiumActivity
import com.example.callscreentheme.privacypolicyactivity
import com.google.common.reflect.Reflection.getPackageName
import kotlin.String.Companion as String1


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SetingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SetingFragment : Fragment() {

    private val mCameraManager: CameraManager? = null
    private val mCameraId: String? = null
    private var cameraId: String? = null
    lateinit var cameraManager:CameraManager

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var binding = FragmentSetingBinding.inflate(layoutInflater)
        binding.premium.setOnClickListener {
            var intent = Intent(context, premiumActivity::class.java)
            startActivity(intent)
        }

        binding.realset5.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            sendIntent.type = "text/plain"
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        binding.realset7.setOnClickListener {
            rateApp()
        }

        binding.realset8.setOnClickListener {
            val intent = Intent(context, privacypolicyactivity::class.java)
            startActivity(intent)
        }


        binding.arrow.setOnClickListener {
            val intent = Intent(context, LanguageActivity::class.java)
            startActivity(intent)
        }

        binding.arrow3.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { View, isChecked ->
            vibratorFun()
            if (binding.arrow3.isChecked){
                binding.Genral6.setText("Turn On")
            }else {
                binding.Genral6.setText("Turn Off")
            }
        })

        binding.arrow2.setOnCheckedChangeListener { compoundButton, b ->
            if (binding.arrow2.isChecked){
                binding.Genral4.setText("Turn On")
            }else {
                binding.Genral4.setText("Turn Off")
            }

        }

        return binding.root
    }



    private fun vibratorFun() {
        var vibrator = activity?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator!!.vibrate(
                VibrationEffect.createOneShot(1000, VibrationEffect.PARCELABLE_WRITE_RETURN_VALUE)
            )
        } else {
            //deprecated in API 26
            vibrator!!.vibrate(1000)
        }
    }

    fun rateApp() {
        try {
            val rateIntent: Intent = rateIntentForUrl("market://details")
            startActivity(rateIntent)
        } catch (e: ActivityNotFoundException) {
            val rateIntent: Intent =
                rateIntentForUrl("https://play.googl.com.example.callscreentheme/")
            startActivity(rateIntent)
        }
    }

    private fun rateIntentForUrl(s: String): Intent {
        val url = "https://play.googl.com.example.callscreentheme/"
        val intent =
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    String1.format(
                        "%s?id=%s",
                        url,
                        getPackageName("com.example.callscreentheme")
                    )
                )
            )
        var flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        flags = if (Build.VERSION.SDK_INT >= 21) {
            flags or Intent.FLAG_ACTIVITY_NEW_DOCUMENT
        } else {
            flags or Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
        }
        intent.addFlags(flags)
        return intent
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SetingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SetingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}