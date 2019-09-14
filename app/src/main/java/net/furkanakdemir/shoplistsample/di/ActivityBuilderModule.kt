package net.furkanakdemir.shoplistsample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import net.furkanakdemir.shoplistsample.MainActivity
import net.furkanakdemir.shoplistsample.network.NetworkModule

@ExperimentalCoroutinesApi
@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class, NetworkModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}
