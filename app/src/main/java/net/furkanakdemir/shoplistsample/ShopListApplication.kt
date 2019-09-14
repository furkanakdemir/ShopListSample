package net.furkanakdemir.shoplistsample

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import net.furkanakdemir.shoplistsample.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

@ExperimentalCoroutinesApi
class ShopListApplication : DaggerApplication() {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<DaggerApplication>

    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }

    private fun setupTimber() {
        Timber.uprootAll()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}
