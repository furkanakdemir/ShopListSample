package net.furkanakdemir.shoplistsample.data

import net.furkanakdemir.shoplistsample.result.Result

interface WidgetRepository {
    suspend fun getWidgets(): Result<List<Widget>>
}
