package net.furkanakdemir.shoplistsample.network

import net.furkanakdemir.shoplistsample.data.WidgetResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WidgetService {

    @GET("/zeus/widget/display")
    suspend fun getWidgets(@Query("widgetPageName") widgetPageName: String): WidgetResponse
}
