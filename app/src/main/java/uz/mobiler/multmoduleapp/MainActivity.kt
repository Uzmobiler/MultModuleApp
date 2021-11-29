package uz.mobiler.multmoduleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.hilt.android.AndroidEntryPoint
import uz.mobiler.multmoduleapp.databinding.ActivityMainBinding
import uz.mobiler.welcome.WelcomeFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frag_container, WelcomeFragment::class.java, null)
                .commit()
        }
    }

    override fun onBackPressed() {
        val fm: FragmentManager = supportFragmentManager
        for (frag in fm.fragments) {
            if (frag.isVisible) {
                val childFm: FragmentManager = frag.childFragmentManager
                if (childFm.backStackEntryCount > 0) {
                    childFm.popBackStack()
                    return
                }
            }
        }
        super.onBackPressed()
    }
}