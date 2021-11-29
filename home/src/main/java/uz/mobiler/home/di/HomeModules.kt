package uz.mobiler.home.di

import androidx.fragment.app.Fragment
import uz.mobiler.home.navigation.home_internal.HomeInternalButtonClickedImpl
import uz.mobiler.home.HomeDependency
import uz.mobiler.home.HomeFragment
import com.kpstv.home.di.HomeQualifier
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import uz.mobiler.home_internal.HomeInternalButtonClicked

@Module
@InstallIn(FragmentComponent::class)
class HomeDependencyModule {
  @Provides
  fun homeDependency(): HomeDependency = HomeDependency()

  @Provides @HomeQualifier
  fun homeFragment(fragment: Fragment) : HomeFragment {
    return fragment.requireActivity().supportFragmentManager.fragments.find { it is HomeFragment } as HomeFragment
  }
}

@Module
@InstallIn(FragmentComponent::class)
abstract class HomeModule {

  @Binds
  abstract fun provideHomeInternalButtonClick(homeButtonClicked: HomeInternalButtonClickedImpl) : HomeInternalButtonClicked
}
