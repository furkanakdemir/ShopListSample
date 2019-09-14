package net.furkanakdemir.shoplistsample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import net.furkanakdemir.shoplistsample.ShopListApplication
import net.furkanakdemir.shoplistsample.image.GlideImageLoader
import net.furkanakdemir.shoplistsample.image.ImageLoader
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: ShopListApplication): Context = application

    @Provides
    @Singleton
    internal fun provideImageLoader(context: Context): ImageLoader = GlideImageLoader(context)
}
