package net.furkanakdemir.shoplistsample.ui

import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.mapper.Mapper
import net.furkanakdemir.shoplistsample.ui.data.Slide
import net.furkanakdemir.shoplistsample.ui.data.ViewItem

class ViewMapper : Mapper<Widget, ViewItem> {
    override fun map(input: Widget?): ViewItem {


        // TODO Fix this complexity
        input?.let {

            when (it.info.displayType) {

                "SINGLE" -> {

                    when (it) {
                        is Widget.Banner -> return ViewItem.SingleViewItem(it.bannerContents.first().imageUrl)
                        is Widget.Products -> return ViewItem.SingleViewItem(it.products.first().imageUrl)
                        else -> return ViewItem.DefaultViewItem
                    }
                }
                "SLIDER" -> {
                    when (it) {
                        is Widget.Banner -> return ViewItem.SliderViewItem(it.bannerContents.map { banner ->
                            Slide(banner.title, banner.subtitle, banner.imageUrl)
                        })
                        is Widget.Products -> return ViewItem.SliderViewItem(it.products.map { product ->
                            Slide(product.name, product.categoryName, product.imageUrl)
                        })
                        else -> return ViewItem.DefaultViewItem
                    }
                }
                "LISTING" -> {
                    when (it) {
                        is Widget.Banner -> return ViewItem.ListingViewItem(it.bannerContents.first().imageUrl)
                        is Widget.Products -> return ViewItem.ListingViewItem(it.products.first().imageUrl)
                        else -> return ViewItem.DefaultViewItem
                    }
                }
                "CAROUSEL" -> {
                    when (it) {
                        is Widget.Banner -> return ViewItem.CarouselViewItem(it.bannerContents.first().imageUrl)
                        is Widget.Products -> return ViewItem.CarouselViewItem(it.products.first().imageUrl)
                        else -> return ViewItem.DefaultViewItem
                    }
                }
                else -> return ViewItem.DefaultViewItem
            }


        }


        return ViewItem.DefaultViewItem
    }

}