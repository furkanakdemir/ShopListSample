package net.furkanakdemir.shoplistsample.data.source

import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.data.WidgetResponse
import net.furkanakdemir.shoplistsample.mapper.ListMapper
import net.furkanakdemir.shoplistsample.network.WidgetService
import javax.inject.Inject

class RemoteWidgetDataSource @Inject constructor(
    private val widgetService: WidgetService,
    private val domainMapper: ListMapper<WidgetResponse.WidgetRaw?, Widget>
) : WidgetDataSource {
    override suspend fun getWidgets(): List<Widget> {
        val remoteWidgets: List<WidgetResponse.WidgetRaw?> =
            widgetService.getWidgets(QUERY_PAGE_NAME).widgetRaws
        return domainMapper.map(remoteWidgets)
    }

    companion object {
        // Constant because it is a test case
        private const val QUERY_PAGE_NAME: String = "interview"
    }
}