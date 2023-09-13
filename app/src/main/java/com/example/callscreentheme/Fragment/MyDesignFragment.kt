package com.example.callscreentheme.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.callscreentheme.Prefs
import com.example.callscreentheme.R
import com.example.callscreentheme.databinding.FragmentMyDesignBinding
import com.example.callscreentheme.premiumActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyDesignFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyDesignFragment : Fragment() {
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
        savedInstanceState: Bundle?
    ): View? {
        var prefs = Prefs(requireContext())
        prefs.addLang("en")
        /*   binding.intro2arrow.setOnClickListener {
               startActivity(Intent(context,Fragment3::class.java))
           }
   */

        var binding = FragmentMyDesignBinding.inflate(layoutInflater)
        prefs.addLang("en")
        prefs.addLang("es")
        prefs.addLang("fr")
        prefs.addLang("hi")
        prefs.addLang("pt")
        prefs.addLang("ru")
        prefs.getLang()
        binding.mytheme.setText(R.string.mytheme)

        binding.premium.setOnClickListener {
            startActivity(Intent(context, premiumActivity::class.java))
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
         * @return A new instance of fragment MyDesignFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyDesignFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}