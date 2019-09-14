package net.furkanakdemir.shoplistsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.furkanakdemir.shoplistsample.ui.WidgetViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WidgetViewModel::class)
    abstract fun bindMessageViewModel(widgetViewModel: WidgetViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ShopListViewModelFactory): ViewModelProvider.Factory
}
