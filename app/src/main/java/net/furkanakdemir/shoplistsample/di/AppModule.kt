package net.furkanakdemir.shoplistsample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import net.furkanakdemir.shoplistsample.ShopListApplication
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: ShopListApplication): Context = application
}
