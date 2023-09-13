package com.example.callscreentheme.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.callscreentheme.Adapter.ScreenThemeListAdapter
import com.example.callscreentheme.Prefs
import com.example.callscreentheme.R
import com.example.callscreentheme.databinding.FragmentScreenThemeBinding
import com.example.callscreentheme.premiumActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScreenThemeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScreenThemeFragment : Fragment() {
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

    var images = arrayOf(
        R.drawable.screen1,
        R.drawable.screen2,
        R.drawable.screen3,
        R.drawable.screen4,
        R.drawable.screen5,
        R.drawable.screen6,
        R.drawable.screen7,
        R.drawable.screen8,
        R.drawable.screen9,
        R.drawable.screen10,
        R.drawable.screen11,
        R.drawable.screen12,
        R.drawable.screen13,
        R.drawable.screen14,
        R.drawable.screen15,
        R.drawable.screen16,
        R.drawable.screen17,
        R.drawable.screen18,
        R.drawable.screen19,
        R.drawable.screen20
    )
    var image = arrayOf(
        R.drawable.all1,
        R.drawable.all2,
        R.drawable.all3,
        R.drawable.all4,
        R.drawable.all5,
        R.drawable.all6,
        R.drawable.all7,
        R.drawable.all8,
        R.drawable.all9,
        R.drawable.all10,
        R.drawable.all11,
        R.drawable.all12,
        R.drawable.all13,
        R.drawable.all14,
        R.drawable.all15,
        R.drawable.all16,
        R.drawable.all17,
        R.drawable.all18,
        R.drawable.all19,
        R.drawable.all20
    )
    var neonimg = arrayOf(R.drawable.neon1, R.drawable.neon2, R.drawable.neon3, R.drawable.neon4)
    var hallimg = arrayOf(R.drawable.hall1, R.drawable.hall2, R.drawable.hall3, R.drawable.hall4)
    var marvelimg = arrayOf(R.drawable.marvel1, R.drawable.marvel2, R.drawable.marvel3, R.drawable.marvel4)
    var astroimg = arrayOf(R.drawable.astro1, R.drawable.astro2, R.drawable.astro3, R.drawable.astro4)
    var natureimg = arrayOf(R.drawable.nature1, R.drawable.nature2, R.drawable.nature3, R.drawable.nature4)

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var prefs = Prefs(requireContext())
        prefs.addLang("en")
        prefs.addLang("en")
        prefs.addLang("es")
        prefs.addLang("fr")
        prefs.addLang("hi")
        prefs.addLang("pt")
        prefs.addLang("ru")
        prefs.getLang()

        var binding = FragmentScreenThemeBinding.inflate(layoutInflater)
        binding.screentheme.setText(R.string.screentheme)
        binding.recycler.layoutManager = GridLayoutManager(context, 2)
        binding.recycler.adapter = ScreenThemeListAdapter(images)

        binding.btn1.setOnClickListener {
            binding.recycler.layoutManager = GridLayoutManager(context, 2)
            binding.recycler.adapter = ScreenThemeListAdapter(images)
            binding.btn1.setBackgroundResource(R.drawable.buttonscreen)
            binding.btn2.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn3.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn4.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn5.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn6.setBackgroundResource(R.drawable.button_bg_color)

        }
        binding.btn2.setOnClickListener {
            binding.recycler.layoutManager = GridLayoutManager(context, 2)
            binding.recycler.adapter = ScreenThemeListAdapter(neonimg)
            binding.btn1.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn2.setBackgroundResource(R.drawable.buttonscreen)
            binding.btn3.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn4.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn5.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn6.setBackgroundResource(R.drawable.button_bg_color)
        }
        binding.btn3.setOnClickListener {
            binding.recycler.layoutManager = GridLayoutManager(context, 2)
            binding.recycler.adapter = ScreenThemeListAdapter(hallimg)
            binding.btn1.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn2.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn3.setBackgroundResource(R.drawable.buttonscreen)
            binding.btn4.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn5.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn6.setBackgroundResource(R.drawable.button_bg_color)
        }
        binding.btn4.setOnClickListener {
            binding.recycler.layoutManager = GridLayoutManager(context, 2)
            binding.recycler.adapter = ScreenThemeListAdapter(marvelimg)
            binding.btn1.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn2.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn3.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn4.setBackgroundResource(R.drawable.buttonscreen)
            binding.btn5.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn6.setBackgroundResource(R.drawable.button_bg_color)
        }
        binding.btn5.setOnClickListener {
            binding.recycler.layoutManager = GridLayoutManager(context, 2)
            binding.recycler.adapter = ScreenThemeListAdapter(astroimg)
            binding.btn1.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn2.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn3.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn4.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn5.setBackgroundResource(R.drawable.buttonscreen)
            binding.btn6.setBackgroundResource(R.drawable.button_bg_color)
        }
        binding.btn6.setOnClickListener {

            binding.recycler.layoutManager = GridLayoutManager(context, 2)
            binding.recycler.adapter = ScreenThemeListAdapter(natureimg)
            binding.btn1.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn2.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn3.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn4.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn5.setBackgroundResource(R.drawable.button_bg_color)
            binding.btn6.setBackgroundResource(R.drawable.buttonscreen)
        }

        binding.premium.setOnClickListener {
                var intent = Intent(context, premiumActivity::class.java)
                startActivity(intent)
        }

        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ScreenThemeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScreenThemeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}