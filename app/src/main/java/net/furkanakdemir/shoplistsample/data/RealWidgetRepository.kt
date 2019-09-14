package net.furkanakdemir.shoplistsample.data

import net.furkanakdemir.shoplistsample.data.source.WidgetDataSource
import javax.inject.Inject

class RealWidgetRepository @Inject constructor(
    private val remoteDataSource: WidgetDataSource
) : WidgetRepository {
    override suspend fun getWidgets(): List<Widget> = remoteDataSource.getWidgets()
}