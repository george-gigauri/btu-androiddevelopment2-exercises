package ge.george.btu_android_exercise_10

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import ge.george.btu_android_exercise_10.databinding.FragmentViewInfoBinding

class ViewInfoFragment : Fragment(R.layout.fragment_view_info) {

    private var _binding: FragmentViewInfoBinding? = null
    private val binding: FragmentViewInfoBinding get() = _binding!!

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentViewInfoBinding.bind(view)

        sharedPreferences = requireActivity().getSharedPreferences(
            "App_Prefs",
            Context.MODE_PRIVATE
        )

        binding.circleImageView.load(sharedPreferences.getString("photo_url", "")){
            placeholder(R.color.teal_700)
            placeholder(R.color.teal_200)
        }

        binding.tvFullName.text = sharedPreferences.getString("full_name", "null")
        binding.tvEmail.text = sharedPreferences.getString("email", "null")
    }

    override fun onResume() {
        super.onResume()

        binding.circleImageView.load(sharedPreferences.getString("photo_url", "")){
            placeholder(R.color.teal_700)
            placeholder(R.color.teal_200)
        }
        binding.tvFullName.text = sharedPreferences.getString("full_name", "null")
        binding.tvEmail.text = sharedPreferences.getString("email", "null")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}