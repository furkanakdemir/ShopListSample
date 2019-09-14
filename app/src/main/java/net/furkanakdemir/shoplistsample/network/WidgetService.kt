package net.furkanakdemir.shoplistsample.network

import net.furkanakdemir.shoplistsample.data.WidgetResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WidgetService {

    // TODO Inject headers via interceptor
    @Headers("Content-Type:application/json", "Build:85")
    @GET("/zeus/widget/display")
    suspend fun getWidgets(@Query("widgetPageName") widgetPageName: String): WidgetResponse
}
