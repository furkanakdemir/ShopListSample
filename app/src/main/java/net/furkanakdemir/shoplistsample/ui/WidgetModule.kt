package net.furkanakdemir.shoplistsample.ui

import dagger.Module
import net.furkanakdemir.shoplistsample.network.NetworkModule

@Module(includes = [NetworkModule::class])
abstract class WidgetModule {
}
