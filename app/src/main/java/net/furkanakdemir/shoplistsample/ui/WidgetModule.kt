package net.furkanakdemir.shoplistsample.ui

import dagger.Binds
import dagger.Module
import dagger.Provides
import net.furkanakdemir.shoplistsample.data.RealWidgetRepository
import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.data.WidgetRepository
import net.furkanakdemir.shoplistsample.data.WidgetResponse
import net.furkanakdemir.shoplistsample.data.source.RemoteWidgetDataSource
import net.furkanakdemir.shoplistsample.data.source.WidgetDataSource
import net.furkanakdemir.shoplistsample.mapper.DomainMapper
import net.furkanakdemir.shoplistsample.mapper.ListMapper
import net.furkanakdemir.shoplistsample.mapper.Mapper
import net.furkanakdemir.shoplistsample.mapper.RealListMapper
import net.furkanakdemir.shoplistsample.network.NetworkModule
import net.furkanakdemir.shoplistsample.ui.data.ViewItem
import net.furkanakdemir.shoplistsample.ui.data.ViewMapper

@Module(includes = [NetworkModule::class])
abstract class WidgetModule {

    @Binds
    abstract fun bindWidgetRepository(repository: RealWidgetRepository): WidgetRepository


    @Binds
    abstract fun bindRemoteWidgetDataSource(remoteWidgetDataSource: RemoteWidgetDataSource)
            : WidgetDataSource

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun bindListDomainMapper(mapper: Mapper<WidgetResponse.WidgetRaw?, Widget>)
                : ListMapper<WidgetResponse.WidgetRaw?, Widget> =
            RealListMapper(mapper)

        @JvmStatic
        @Provides
        fun bindDomainMapper(): Mapper<WidgetResponse.WidgetRaw?, Widget> = DomainMapper()

        @JvmStatic
        @Provides
        fun bindViewMapper(): Mapper<Widget, ViewItem> =
            ViewMapper()
    }
}
