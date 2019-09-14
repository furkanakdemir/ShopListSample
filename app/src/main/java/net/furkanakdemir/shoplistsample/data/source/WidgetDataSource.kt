package net.furkanakdemir.shoplistsample.data.source

import net.furkanakdemir.shoplistsample.data.Widget

interface WidgetDataSource {
    suspend fun getWidgets(): List<Widget>
}