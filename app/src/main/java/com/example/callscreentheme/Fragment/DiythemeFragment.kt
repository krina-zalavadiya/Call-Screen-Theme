package com.example.callscreentheme.Fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.callscreentheme.Adapter.DiyThemeListAdapter
import com.example.callscreentheme.Prefs
import com.example.callscreentheme.R
import com.example.callscreentheme.databinding.FragmentDiyBinding
import com.example.callscreentheme.databinding.FragmentMyDesignBinding
import com.example.callscreentheme.premiumActivity

private val Any.avatar1: Any
    get() {
        TODO("Not yet implemented")
    }

private fun Any.setImageURI(uri: Uri) {
    TODO("Not yet implemented")
}

/**
 * A simple [Fragment] subclass.
 * Use the [DiythemeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("UNREACHABLE_CODE")
class DiythemeFragment : Fragment() {
    /*
    var binding = FragmentDiyBinding.inflate(layoutInflater)
*/

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
            mParam2 = requireArguments().getString(ARG_PARAM2)
        }
    }

    var diyimg = arrayOf(
        R.drawable.diybg1,
        R.drawable.diybg2,
        R.drawable.diybg3,
        R.drawable.diybg4,
        R.drawable.diybg5,
        R.drawable.diybg6,
        R.drawable.diybg7,
        R.drawable.diybg8,
        R.drawable.diybg9,
        R.drawable.diybg10
    )

    private val SELECT_IMAGE_REQUEST = 1 // Request code for image selection

    private lateinit var imageView: ImageView
    lateinit var uri: Uri
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

        prefs.addLang("en")
        prefs.addLang("es")
        prefs.addLang("fr")
        prefs.addLang("hi")
        prefs.addLang("pt")
        prefs.addLang("ru")
        prefs.getLang()
        var binding = FragmentDiyBinding.inflate(layoutInflater)
        binding.diytheme.setText(R.string.diytheme)
        binding.icon.setText(R.string.icon)
        binding.avatar.setText(R.string.avatar)
        binding.recycler1.layoutManager = GridLayoutManager(context, 2)
        binding.recycler1.adapter = DiyThemeListAdapter(diyimg)

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, 21)
        binding.avatar1.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK)
            galleryIntent.type = "image/*"
            startActivityForResult(galleryIntent, 21)
        }

        binding.premium.setOnClickListener {
            startActivity(Intent(context, premiumActivity::class.java))
        }
        return binding.root
    }

    private fun onActivityResult(
        galleryIntent: Intent,
        requestCode: Int,
        resultCode: Int,
        data: Intent,
        binding: Any
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 21) {
                uri = data.data!!
                binding.run {
                    binding.avatar1.setImageURI(uri)
                }

//                binding.avatar1.setImagResource(uri)
            }
        }
    }

    companion object {

        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        fun newInstance(param1: String?, param2: String?): DiythemeFragment {
            val fragment = DiythemeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}




