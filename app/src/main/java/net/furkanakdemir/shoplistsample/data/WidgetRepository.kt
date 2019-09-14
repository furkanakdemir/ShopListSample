package net.furkanakdemir.shoplistsample.data

interface WidgetRepository {
    suspend fun getWidgets(): List<Widget>
}