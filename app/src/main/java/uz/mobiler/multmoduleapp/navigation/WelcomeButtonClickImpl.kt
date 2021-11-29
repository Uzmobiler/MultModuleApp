package uz.mobiler.multmoduleapp.navigation

import androidx.fragment.app.FragmentActivity
import uz.mobiler.home.HomeFragment
import uz.mobiler.multmoduleapp.R
import uz.mobiler.welcome.WelcomeButtonClick
import javax.inject.Inject

class WelcomeButtonClickImpl @Inject constructor(
  private val activity: FragmentActivity /* Provides the nearest fragment activity */
) : WelcomeButtonClick {
  override fun goToNext() {
    activity.supportFragmentManager.beginTransaction()
      .addToBackStack("home")
      .replace(R.id.frag_container, HomeFragment::class.java, null)
      .commit()
  }
}