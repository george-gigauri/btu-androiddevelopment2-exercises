package ge.george.btu_android_exercise_10

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import coil.load
import com.bumptech.glide.Glide
import ge.george.btu_android_exercise_10.databinding.FragmentEditInfoBinding

class EditInfoFragment : Fragment(R.layout.fragment_edit_info) {

    private var _binding: FragmentEditInfoBinding? = null
    private val binding: FragmentEditInfoBinding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditInfoBinding.bind(view)

        sharedPreferences = requireActivity().getSharedPreferences("App_Prefs", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        binding.etImage.doAfterTextChanged {
            binding.circleImageView.load(binding.etImage.text.toString()){
                placeholder(R.color.teal_700)
                placeholder(R.color.teal_200)
            }
        }

        binding.etImage.setText(sharedPreferences.getString("photo_url", null))
        binding.etFullName.setText(sharedPreferences.getString("full_name", null))
        binding.etEmail.setText(sharedPreferences.getString("email", null))

        binding.btnSave.setOnClickListener {
            editor.putString("photo_url", binding.etImage.text.toString())
            editor.putString("full_name", binding.etFullName.text.toString())
            editor.putString("email", binding.etEmail.text.toString())
            editor.apply()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}