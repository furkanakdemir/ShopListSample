package net.furkanakdemir.shoplistsample.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import net.furkanakdemir.shoplistsample.ShopListApplication
import net.furkanakdemir.shoplistsample.network.NetworkModule
import net.furkanakdemir.shoplistsample.ui.WidgetModule
import net.furkanakdemir.shoplistsample.viewmodel.ViewModelModule
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class,
        AppModule::class, ActivityBuilderModule::class, ViewModelModule::class,
        NetworkModule::class, WidgetModule::class]
)
interface AppComponent : AndroidInjector<ShopListApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<ShopListApplication>
}
