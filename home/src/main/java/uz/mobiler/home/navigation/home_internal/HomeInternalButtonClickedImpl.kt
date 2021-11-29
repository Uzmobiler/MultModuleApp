package uz.mobiler.home.navigation.home_internal

import com.kpstv.home.di.HomeQualifier
import uz.mobiler.home.HomeFragment
import uz.mobiler.home.R
import uz.mobiler.home_internal.HomeInternalButtonClicked
import uz.mobiler.home_internal2.HomeInternal2Fragment
import javax.inject.Inject

class HomeInternalButtonClickedImpl @Inject constructor(
  @HomeQualifier private val fragment: HomeFragment,
) : HomeInternalButtonClicked {
  override fun goToNext() {
    fragment.childFragmentManager.beginTransaction()
      .addToBackStack("home-internal2")
      .replace(R.id.frag_container, HomeInternal2Fragment::class.java, null)
      .commit()
  }
}