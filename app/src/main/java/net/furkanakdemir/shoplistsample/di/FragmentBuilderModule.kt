package net.furkanakdemir.shoplistsample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import net.furkanakdemir.shoplistsample.ui.detail.WidgetDetailFragment
import net.furkanakdemir.shoplistsample.ui.list.WidgetListFragment

@ExperimentalCoroutinesApi
@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun bindWidgetListFragment(): WidgetListFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun bindWidgetDetailFragment(): WidgetDetailFragment
}
