package net.furkanakdemir.shoplistsample.mapper

import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.data.WidgetResponse
import javax.inject.Inject

class DomainMapper @Inject constructor() : Mapper<WidgetResponse.WidgetRaw?, Widget> {
    override fun map(input: WidgetResponse.WidgetRaw?): Widget {
        return Widget(1)
    }
}