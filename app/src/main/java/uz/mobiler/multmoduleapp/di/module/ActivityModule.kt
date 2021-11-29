package uz.mobiler.multmoduleapp.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import uz.mobiler.multmoduleapp.navigation.WelcomeButtonClickImpl
import uz.mobiler.welcome.WelcomeButtonClick

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {
    @Binds
    abstract fun provideWelcomeButtonClick(welcomeButtonClick: WelcomeButtonClickImpl) : WelcomeButtonClick
}