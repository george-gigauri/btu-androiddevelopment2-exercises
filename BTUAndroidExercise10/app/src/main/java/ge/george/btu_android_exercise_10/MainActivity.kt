package ge.george.btu_android_exercise_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ge.george.btu_android_exercise_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}